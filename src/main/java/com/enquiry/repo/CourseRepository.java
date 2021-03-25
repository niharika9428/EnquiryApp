package com.enquiry.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enquiry.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	@Query("SELECT c.courseId as courseId, c.name as name, c.fees as fees , c.institute.name as instituteName FROM Course as c")
	List<Map<String,Object>> getCoursesList();
	
	List<Course> findCoursesByInstitute_instituteId(Long instituteId);

}
