package com.example.demo.service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.ContactFullDTO;
import com.example.demo.entity.Contact;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.repo.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {

    private final ContactRepository contactRepository;

    public List<ContactDTO> getAll() {
        return contactRepository.findAll()
                .stream()
                .map(ContactDTO::toDTO)
                .toList();
    }

    public ContactFullDTO getById(Long id) {
        return ContactFullDTO.toDTO(getOrThrow(id));
    }

    public ContactDTO deleteById(Long id) {
        final var entityToDelete = getOrThrow(id);
        contactRepository.delete(entityToDelete);
        return ContactDTO.toDTO(entityToDelete);
    }

    public ContactDTO updateById(Long id, ContactDTO contactDTO) {
        final var entityToUpdate = getOrThrow(id);
        entityToUpdate.setFirstName(contactDTO.firstName());
        entityToUpdate.setLastName(contactDTO.lastName());
        return ContactDTO.toDTO(contactRepository.save(entityToUpdate));
    }

    public Contact getOrThrow(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    public ContactDTO add(ContactDTO contactDTO) {
        return ContactDTO.toDTO(contactRepository.save(new Contact(contactDTO.firstName(), contactDTO.lastName())));
    }
}
