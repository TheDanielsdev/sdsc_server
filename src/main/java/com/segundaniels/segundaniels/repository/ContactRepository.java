package com.segundaniels.segundaniels.repository;


import com.segundaniels.segundaniels.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}

