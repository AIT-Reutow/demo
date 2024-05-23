package com.example.demo.service;

import com.example.demo.dto.ContactAddressDTO;
import com.example.demo.entity.ContactAddress;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.repo.ContactAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactAddressService {

    private final ContactAddressRepository contactAddressRepository;
    private final ContactService contactService;


    public List<ContactAddressDTO> getAll() {
        return contactAddressRepository.findAll()
                .stream()
                .map(ContactAddressDTO::toDTO)
                .toList();
    }

    public ContactAddressDTO getById(Long id) {
        return ContactAddressDTO.toDTO(getOrThrow(id));
    }

    public ContactAddressDTO deleteById(Long id) {
        final var entityToDelete = getOrThrow(id);
        contactAddressRepository.delete(entityToDelete);
        return ContactAddressDTO.toDTO(entityToDelete);
    }

    public ContactAddressDTO updateById(Long id, ContactAddressDTO updateDto) {
        final var entityToUpdate = getOrThrow(id);
        entityToUpdate.setCountry(updateDto.country());
        entityToUpdate.setZipCode(updateDto.zipCode());
        entityToUpdate.setCity(updateDto.city());
        entityToUpdate.setStreet1(updateDto.street1());
        entityToUpdate.setStreet2(updateDto.street2());
        return ContactAddressDTO.toDTO(entityToUpdate);
    }

    public ContactAddress getOrThrow(Long id) {
        return contactAddressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    public ContactAddressDTO addAddressToContact(Long contactId, ContactAddressDTO contactAddressDTO) {
        var contact = contactService.getOrThrow(contactId);

        ContactAddress contactAddress = new ContactAddress();
        contactAddress.setCountry(contactAddressDTO.country());
        contactAddress.setCity(contactAddressDTO.city());
        contactAddress.setZipCode(contactAddressDTO.zipCode());
        contactAddress.setStreet1(contactAddressDTO.street1());
        contactAddress.setStreet2(contactAddressDTO.street2());
        contactAddress.setContact(contact);

        ContactAddress savedAddress = contactAddressRepository.save(contactAddress);
        return ContactAddressDTO.toDTO(savedAddress);
    }
}
