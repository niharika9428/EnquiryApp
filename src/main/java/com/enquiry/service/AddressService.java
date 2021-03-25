package com.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.domain.Address;
import com.enquiry.repo.AddressRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	public void save(Address address) {
		addressRepository.save(address);
	}

}
