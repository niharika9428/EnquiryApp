package com.enquiry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enquiry.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
