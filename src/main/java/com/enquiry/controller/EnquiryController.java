package com.enquiry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.enquiry.domain.Course;
import com.enquiry.domain.EnquirySource;
import com.enquiry.domain.Institute;
import com.enquiry.dto.EnquiryCommand;
import com.enquiry.service.CourseService;
import com.enquiry.service.EnquiryService;
import com.enquiry.service.InstituteService;

@Controller
public class EnquiryController {

	@Autowired
	EnquiryService enquiryService;
	
	@Autowired
	InstituteService instituteService;
	
	@Autowired
	CourseService courseService;
	
	@GetMapping("/")
	public String index(Model model) {
		EnquiryCommand cmd = new EnquiryCommand();
		model.addAttribute("cmd",cmd);
		return "index";
	}
	
	@ModelAttribute("sourceList")
	public List<EnquirySource> getSourcesList(){
		return enquiryService.getSourcesList();
	}
	
	@ModelAttribute("instituteList")
	public List<Institute> getInstituteIdNameList(){
		return instituteService.getInstituteIdNameList();
	}
	
	@GetMapping("/get-courses")
	@ResponseBody
	public List<Course> getCoursesByInstituteById(@RequestParam Long instId){
		return courseService.getCoursesByInstituteById(instId);
	}
	
	@GetMapping("/save-enquiry")
	public String saveEnquiry(@ModelAttribute EnquiryCommand enquiryCommand) {
		enquiryService.saveEnquiry(enquiryCommand);
		return "Saved successfully";
	}
}
