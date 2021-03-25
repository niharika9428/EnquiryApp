package com.enquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.domain.Contact;
import com.enquiry.repo.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	ContactRepository contactRepository;

	public void save(Contact contact) {
		contactRepository.save(contact);
	}

}
