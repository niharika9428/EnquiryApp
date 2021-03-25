package com.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enquiry.domain.EnquirySource;
import com.enquiry.repo.EnquirySourceRepository;

@RestController
public class TestController {
	
	@Autowired
	EnquirySourceRepository repo;

	@PostMapping("/test-save-source")
	public EnquirySource testSaveSource(@RequestBody EnquirySource enquirySource) {
		return repo.save(enquirySource);
	}
	
	@GetMapping("/get-saved-source")
	public List getSaveSource() {
		return  repo.findAll();
	}
	
}
