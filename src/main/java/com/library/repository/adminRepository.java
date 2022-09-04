package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.admin;

@Repository
public interface adminRepository extends JpaRepository<admin, Long> {
	
}
