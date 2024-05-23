package com.example.demo.controller;

import com.example.demo.dto.ContactEmailDTO;
import com.example.demo.service.ContactEmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact/email")
@RequiredArgsConstructor
public class ContactEmailController {

    private final ContactEmailService contactEmailService;

    @Operation(summary = "Get all contact emails", description = "Returns a list of all contact emails")
    @GetMapping()
    public List<ContactEmailDTO> getAll() {
        return contactEmailService.getAll();
    }

    @Operation(summary = "Get contact email by ID", description = "Returns a contact email based on ID")
    @GetMapping("/{id}")
    public ContactEmailDTO getById(
            @Parameter(description = "ID of the contact email to be fetched", required = true)
            @PathVariable Long id) {
        return contactEmailService.getById(id);
    }

    @Operation(summary = "Update contact email by ID", description = "Updates the contact email based on ID")
    @PutMapping("/{id}")
    public ContactEmailDTO update(
            @Parameter(description = "ID of the contact email to be updated", required = true)
            @PathVariable Long id,
            @RequestBody ContactEmailDTO contactDTO) {
        return contactEmailService.updateById(id, contactDTO);
    }

    @Operation(summary = "Delete contact email by ID", description = "Deletes the contact email based on ID")
    @DeleteMapping("/{id}")
    public ContactEmailDTO delete(
            @Parameter(description = "ID of the contact email to be deleted", required = true)
            @PathVariable Long id) {
        return contactEmailService.deleteById(id);
    }
}
