package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.reader;

@Repository
public interface readerRepository extends JpaRepository<reader, Long> {
	
}
