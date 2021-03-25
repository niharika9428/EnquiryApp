package com.enquiry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enquiry.domain.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

}
