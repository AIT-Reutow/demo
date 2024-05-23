package com.example.demo.controller;

import com.example.demo.dto.ContactAddressDTO;
import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.ContactEmailDTO;
import com.example.demo.dto.ContactFullDTO;
import com.example.demo.service.ContactAddressService;
import com.example.demo.service.ContactEmailService;
import com.example.demo.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;
    private final ContactAddressService contactAddressService;
    private final ContactEmailService contactEmailService;

    @Operation(summary = "Get all contacts", description = "Returns a list of all contacts")
    @GetMapping()
    public List<ContactDTO> getAll() {
        return contactService.getAll();
    }

    @Operation(summary = "Get contact by ID", description = "Returns a contact based on ID")
    @GetMapping("/{id}")
    public ContactFullDTO getById(
            @Parameter(description = "ID of the contact to be fetched", required = true)
            @PathVariable Long id) {
        return contactService.getById(id);
    }

    @Operation(summary = "Update contact by ID", description = "Updates the contact based on ID")
    @PutMapping("/{id}")
    public ContactDTO update(
            @Parameter(description = "ID of the contact to be updated", required = true)
            @PathVariable Long id,
            @RequestBody ContactDTO contactDTO) {
        return contactService.updateById(id, contactDTO);
    }

    @Operation(summary = "Delete contact by ID", description = "Deletes the contact based on ID")
    @DeleteMapping("/{id}")
    public ContactDTO delete(
            @Parameter(description = "ID of the contact to be deleted", required = true)
            @PathVariable Long id) {
        return contactService.deleteById(id);
    }

    @Operation(summary = "Add address to contact", description = "Adds an address to the contact")
    @PostMapping("/{id}/address")
    public ContactAddressDTO addAddress(
            @Parameter(description = "ID of the contact to add address to", required = true)
            @PathVariable Long id,
            @RequestBody ContactAddressDTO contactAddressDTO) {
        return contactAddressService.addAddressToContact(id, contactAddressDTO);
    }

    @Operation(summary = "Add email to contact", description = "Adds an email to the contact")
    @PostMapping("/{id}/email")
    public ContactEmailDTO addEmail(
            @Parameter(description = "ID of the contact to add email to", required = true)
            @PathVariable Long id,
            @RequestBody ContactEmailDTO contactEmailDTO) {
        return contactEmailService.addEmailToContact(id, contactEmailDTO);
    }
}
