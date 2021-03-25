package com.enquiry.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.domain.Address;
import com.enquiry.domain.Contact;
import com.enquiry.domain.Enquiry;
import com.enquiry.domain.EnquiryCourse;
import com.enquiry.domain.EnquirySource;
import com.enquiry.dto.EnquiryCommand;
import com.enquiry.repo.CourseRepository;
import com.enquiry.repo.EnquiryRepository;
import com.enquiry.repo.EnquirySourceRepository;
import com.enquiry.repo.InstituteRepository;

@Service
public class EnquiryService {

	@Autowired
	EnquirySourceRepository enquirySourceRepository;
	@Autowired
	AddressService addressService;
	@Autowired
	ContactService contactService;
	@Autowired
	InstituteRepository instituteRepository;
	@Autowired
	EnquiryRepository enquiryRepository;
	@Autowired
	CourseRepository courseRepository;
	
	public List<EnquirySource> getSourcesList() {
		return enquirySourceRepository.findAll();
	}

	@Transactional
	public void saveEnquiry(EnquiryCommand enquiryCommand) {
		
		Address address = enquiryCommand.getEnquiry().getContact().getPermanentAddress();
		addressService.save(address);
		
		Contact contact = enquiryCommand.getEnquiry().getContact();
		contactService.save(contact);
		
		Enquiry enquiry = enquiryCommand.getEnquiry();
		enquiry.setInstitute(instituteRepository.getOne(enquiry.getInstitute().getInstituteId()));
		enquiry.setEnquirySource(enquirySourceRepository.getOne(enquiry.getEnquirySource().getEnquirySourceId()));
		enquiry.setDoe(new Date());
		enquiry.setLastUpdate(new Date());
		
		enquiryRepository.save(enquiry);
		
		Long[] courseIds = enquiryCommand.getCourseIds();
		
		for (Long courseId : courseIds) {
			EnquiryCourse ec = new EnquiryCourse();
			ec.setEnquiry(enquiry);
			ec.setCourse(courseRepository.getOne(courseId));
		}
		
	}

}
