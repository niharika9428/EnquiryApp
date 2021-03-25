package com.enquiry.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.enquiry.domain.Institute;
import com.enquiry.dto.InstituteDto;

public interface InstituteRepository extends JpaRepository<Institute, Long> {

	@Query("SELECT i.instituteId AS instituteId, i.name AS name , i.contact.phone AS phone , i.contact.email AS email ,i.contact.permanentAddress.city AS city FROM Institute AS i")
	List<InstituteDto> getInstituteList();

	@Query("SELECT new com.enquiry.domain.Institute(i.instituteId,i.name) FROM Institute as i")
	List<Institute> getInstituteIdNameList();
}
