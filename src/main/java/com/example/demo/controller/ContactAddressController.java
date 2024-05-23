package com.example.demo.controller;

import com.example.demo.dto.ContactAddressDTO;
import com.example.demo.service.ContactAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact/address")
@RequiredArgsConstructor
public class ContactAddressController {

    private final ContactAddressService contactAddressService;

    @Operation(summary = "Get all contact addresses", description = "Returns a list of all contact addresses")
    @GetMapping()
    public List<ContactAddressDTO> getAll() {
        return contactAddressService.getAll();
    }

    @Operation(summary = "Get contact address by ID", description = "Returns a contact address based on ID")
    @GetMapping("/{id}")
    public ContactAddressDTO getById(
            @Parameter(description = "ID of the contact address to be fetched", required = true)
            @PathVariable Long id) {
        return contactAddressService.getById(id);
    }

    @Operation(summary = "Update contact address by ID", description = "Updates the contact address based on ID")
    @PutMapping("/{id}")
    public ContactAddressDTO update(
            @Parameter(description = "ID of the contact address to be updated", required = true)
            @PathVariable Long id,
            @RequestBody ContactAddressDTO contactDTO) {
        return contactAddressService.updateById(id, contactDTO);
    }

    @Operation(summary = "Delete contact address by ID", description = "Deletes the contact address based on ID")
    @DeleteMapping("/{id}")
    public ContactAddressDTO delete(
            @Parameter(description = "ID of the contact address to be deleted", required = true)
            @PathVariable Long id) {
        return contactAddressService.deleteById(id);
    }
}
