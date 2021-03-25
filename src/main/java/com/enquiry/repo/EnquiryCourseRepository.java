package com.enquiry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enquiry.domain.EnquiryCourse;

public interface EnquiryCourseRepository extends JpaRepository<EnquiryCourse, Long> {

}
