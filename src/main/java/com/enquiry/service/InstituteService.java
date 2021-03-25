package com.enquiry.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enquiry.domain.Institute;
import com.enquiry.dto.InstituteDto;
import com.enquiry.repo.InstituteRepository;

@Service
public class InstituteService {

	@Autowired
	AddressService addressService;
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	InstituteRepository instituteRepository;
	
	@Transactional
	public void save(Institute inst) {
		
		inst.setDoe(new Date());
		inst.getContact().setName(inst.getName());
		
		addressService.save(inst.getContact().getPermanentAddress());
		
		contactService.save(inst.getContact());
		
		instituteRepository.save(inst);
		
	}

	public List<Institute> findAll() {
		return instituteRepository.findAll();
	}
	
	public List<InstituteDto> getInstituteList() {
		return instituteRepository.getInstituteList();
	}

	public List<Institute> getInstituteIdNameList() {
		return instituteRepository.getInstituteIdNameList();
	}

	public void deleteById(Long id) {
		instituteRepository.deleteById(id);
	}

}
