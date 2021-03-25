package com.enquiry.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.domain.Course;
import com.enquiry.repo.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	public List<Map<String, Object>> getCoursesList() {
		return courseRepository.getCoursesList();
	}

	public List<Course> getCoursesByInstituteById(Long id) {
		return courseRepository.findCoursesByInstitute_instituteId(id);
	}

}
