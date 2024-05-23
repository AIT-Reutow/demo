package com.example.demo.dto;

import com.example.demo.entity.Contact;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO representing a contact")
public record ContactDTO(
        @Schema(description = "Unique identifier of the contact", example = "1")
        Long id,

        @Schema(description = "First name of the contact", example = "John")
        String firstName,

        @Schema(description = "Last name of the contact", example = "Doe")
        String lastName) {

    public static ContactDTO toDTO(Contact contact) {
        return new ContactDTO(contact.getId(),
                contact.getFirstName(),
                contact.getLastName()
        );
    }
}
