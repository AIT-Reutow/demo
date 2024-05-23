package com.example.demo.repo;

import com.example.demo.entity.ContactEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactEmailsRepository extends JpaRepository<ContactEmail, Long> {
}
