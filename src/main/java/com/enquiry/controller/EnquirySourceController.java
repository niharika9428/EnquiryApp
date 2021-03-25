package com.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.enquiry.domain.EnquirySource;
import com.enquiry.repo.EnquirySourceRepository;

@Controller
public class EnquirySourceController {
	
	@Autowired
	private EnquirySourceRepository enquirySourceRepository;

	@GetMapping("/sources")
	public String enquirySources(Model model) {
		EnquirySource cmd = new EnquirySource();
		model.addAttribute("cmd", cmd);
		return "sources";
	}
	
	@PostMapping("/sources")
	public String save(@ModelAttribute EnquirySource es) {
		enquirySourceRepository.save(es);
		return "redirect:sources";
	}
	
	@ModelAttribute("enquirySourceList")
	public List<EnquirySource> getEnquirySourceList() {
		return enquirySourceRepository.findAll();
	}
	
	@GetMapping("/sources/edit/{id}")
	public String getSourceEditForm(@PathVariable Long id,Model model) {
		
		EnquirySource cmd = enquirySourceRepository.findById(id).get();
		model.addAttribute("cmd", cmd);
		return "sources";
	}
	
	@GetMapping("/sources/delete/{id}")
	public String deleteSource(@PathVariable Long id) {
		enquirySourceRepository.deleteById(id);
		return "redirect:/sources";
	}
}
