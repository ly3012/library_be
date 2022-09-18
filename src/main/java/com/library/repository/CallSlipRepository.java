package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.callSlip;

@Repository
public interface CallSlipRepository extends JpaRepository<callSlip, Long> {
	
}
