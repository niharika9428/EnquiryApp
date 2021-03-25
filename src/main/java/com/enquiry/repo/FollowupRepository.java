package com.enquiry.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enquiry.domain.Followup;

public interface FollowupRepository extends JpaRepository<Followup, Long> {

}
