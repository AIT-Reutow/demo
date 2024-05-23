package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String city;
    private String zipCode;
    private String street1;
    private String street2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactAddress that)) return false;

        return Objects.equals(id, that.id) && Objects.equals(country, that.country) && Objects.equals(city, that.city) && Objects.equals(zipCode, that.zipCode) && Objects.equals(street1, that.street1) && Objects.equals(street2, that.street2) && Objects.equals(contact, that.contact);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(country);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(zipCode);
        result = 31 * result + Objects.hashCode(street1);
        result = 31 * result + Objects.hashCode(street2);
        result = 31 * result + Objects.hashCode(contact);
        return result;
    }
}
