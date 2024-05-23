package com.example.demo.repo;

import com.example.demo.entity.ContactAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactAddressRepository extends JpaRepository<ContactAddress, Long> {
}
