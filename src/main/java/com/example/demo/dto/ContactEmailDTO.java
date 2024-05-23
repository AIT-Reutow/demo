package com.example.demo.dto;

import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactEmail;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO representing a contact email")
public record ContactEmailDTO(
        @Schema(description = "Unique identifier of the contact email", example = "1")
        Long id,

        @Schema(description = "Email address", example = "john.doe@example.com")
        String email,

        @Schema(description = "ID of the associated contact", example = "1")
        Long contactId) {

    public static ContactEmailDTO toDTO(ContactEmail contactEmail) {
        final Contact contact = contactEmail.getContact();
        return new ContactEmailDTO(contactEmail.getId(),
                contactEmail.getEmail(),
                contact == null ? null : contact.getId());
    }
}
