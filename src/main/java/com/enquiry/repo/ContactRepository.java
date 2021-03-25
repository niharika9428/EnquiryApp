package com.enquiry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enquiry.domain.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
