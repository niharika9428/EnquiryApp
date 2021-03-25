package com.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enquiry.domain.Institute;
import com.enquiry.dto.InstituteDto;
import com.enquiry.service.InstituteService;

@Controller
public class InstituteController {
	
	@Autowired
	InstituteService instituteService;

	@GetMapping("/institute-form")
	public String instituteForm(Model model){
		Institute inst = new Institute();
		model.addAttribute("cmd", inst);
		return "institute-form";
	}
	
	@PostMapping("/institute/save")
	public String instituteForm(@ModelAttribute Institute inst){
		instituteService.save(inst);
		return "redirect:/institute-list";
	}
	
	@GetMapping("/institute-list")
	public String getInstituteListing(Model model){
		List<InstituteDto> instList = instituteService.getInstituteList();
		model.addAttribute("instList", instList);
		return "institute-list";
	}
	
	@RequestMapping("/institute/delete/{id}")
	public String deleteInstitute(@PathVariable Long id) {
		instituteService.deleteById(id);
		return "redirect:/institute-list";
	}
	
	
}
