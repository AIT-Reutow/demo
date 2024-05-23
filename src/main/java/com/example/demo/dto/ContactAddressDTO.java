package com.example.demo.dto;

import com.example.demo.entity.Contact;
import com.example.demo.entity.ContactAddress;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO representing a contact address")
public record ContactAddressDTO(
        @Schema(description = "Unique identifier of the contact address", example = "1")
        Long id,

        @Schema(description = "Country of the contact address", example = "USA")
        String country,

        @Schema(description = "City of the contact address", example = "New York")
        String city,

        @Schema(description = "Zip code of the contact address", example = "10001")
        String zipCode,

        @Schema(description = "Street1 of the contact address", example = "123 Main St")
        String street1,

        @Schema(description = "Street2 of the contact address", example = "Apt 4B")
        String street2,

        @Schema(description = "ID of the associated contact", example = "1")
        Long contactId) {

    public static ContactAddressDTO toDTO(ContactAddress contactAddress) {
        final Contact contact = contactAddress.getContact();
        return new ContactAddressDTO(
                contactAddress.getId(),
                contactAddress.getCountry(),
                contactAddress.getCity(),
                contactAddress.getZipCode(),
                contactAddress.getStreet1(),
                contactAddress.getStreet2(),
                contact == null ? null : contact.getId()
        );
    }
}
