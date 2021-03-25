package com.enquiry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enquiry.domain.EnquirySource;

public interface EnquirySourceRepository extends JpaRepository<EnquirySource, Long>{

}
