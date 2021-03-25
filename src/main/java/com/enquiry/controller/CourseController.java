package com.enquiry.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.enquiry.domain.Course;
import com.enquiry.domain.Institute;
import com.enquiry.service.CourseService;
import com.enquiry.service.InstituteService;

@Controller
public class CourseController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	InstituteService instituteService;
	
	@GetMapping("/courses")
	public String courseForm(Model m) {
		m.addAttribute("cmd", new Course());
		return "courses";
	}
	
	@ModelAttribute("instituteList")
	public List<Institute> getInstituteIdNameList(){
		return instituteService.getInstituteIdNameList();
	}
	
	@ModelAttribute("courseList")
	public List<Map<String, Object>> getCoursesList(){
		return courseService.getCoursesList();
	}
}
