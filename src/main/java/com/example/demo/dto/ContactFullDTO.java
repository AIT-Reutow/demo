package com.example.demo.dto;

import com.example.demo.entity.Contact;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "DTO representing a full contact with emails and addresses")
public record ContactFullDTO(
        @Schema(description = "Unique identifier of the contact", example = "1")
        Long id,

        @Schema(description = "First name of the contact", example = "John")
        String firstName,

        @Schema(description = "Last name of the contact", example = "Doe")
        String lastName,

        @Schema(description = "List of contact's emails")
        List<ContactEmailDTO> emails,

        @Schema(description = "List of contact's addresses")
        List<ContactAddressDTO> addresses) {

    public static ContactFullDTO toDTO(Contact contact) {
        return new ContactFullDTO(contact.getId(),
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmails().stream().map(ContactEmailDTO::toDTO).toList(),
                contact.getAddresses().stream().map(ContactAddressDTO::toDTO).toList()
        );
    }
}
