package com.library.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.User;
import com.library.entity.callSlip;

@Repository
public interface CallSlipRepository extends JpaRepository<callSlip, Long> {
	
}
