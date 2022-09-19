package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.reader;

@Repository
public interface ReaderRepository extends JpaRepository<reader, Long> {
	
	@Query("SELECT r FROM reader r WHERE "+
			 "r.fullName LIKE CONCAT('%', :query, '%')")
	List<reader> findByCriteria(String query);
}
