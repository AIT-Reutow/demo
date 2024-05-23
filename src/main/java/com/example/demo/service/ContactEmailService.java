package com.example.demo.service;

import com.example.demo.dto.ContactEmailDTO;
import com.example.demo.entity.ContactEmail;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.repo.ContactEmailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactEmailService {

    private final ContactEmailsRepository contactEmailRepository;
    private final ContactService contactService;

    public List<ContactEmailDTO> getAll() {
        return contactEmailRepository.findAll()
                .stream()
                .map(ContactEmailDTO::toDTO)
                .toList();
    }

    public ContactEmailDTO getById(Long id) {
        return ContactEmailDTO.toDTO(getOrThrow(id));
    }

    public ContactEmailDTO deleteById(Long id) {
        final var entityToDelete = getOrThrow(id);
        contactEmailRepository.delete(entityToDelete);
        return ContactEmailDTO.toDTO(entityToDelete);
    }

    public ContactEmailDTO updateById(Long id, ContactEmailDTO updateDto) {
        final var entityToUpdate = getOrThrow(id);
        entityToUpdate.setEmail(updateDto.email());
        return ContactEmailDTO.toDTO(entityToUpdate);
    }

    public ContactEmail getOrThrow(Long id) {
        return contactEmailRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    public ContactEmailDTO addEmailToContact(Long contactId, ContactEmailDTO contactEmailDTO) {
        var contact = contactService.getOrThrow(contactId);

        ContactEmail contactEmail = new ContactEmail();
        contactEmail.setEmail(contactEmailDTO.email());
        contactEmail.setContact(contact);

        ContactEmail savedEmail = contactEmailRepository.save(contactEmail);
        return ContactEmailDTO.toDTO(savedEmail);
    }
}
