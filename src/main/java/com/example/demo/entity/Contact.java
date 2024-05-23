package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact extends EntityId {

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ContactEmail> emails = new ArrayList<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ContactAddress> addresses = new ArrayList<>();

    public void addEmail(ContactEmail email) {
        emails.add(email);
        email.setContact(this);
    }

    public void removeEmail(ContactEmail email) {
        emails.remove(email);
        email.setContact(null);
    }

    public void addAddress(ContactAddress address) {
        addresses.add(address);
        address.setContact(this);
    }

    public void removeAddress(ContactAddress address) {
        addresses.remove(address);
        address.setContact(null);
    }
}
