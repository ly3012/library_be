package com.library.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.callSlip;
import com.library.entity.reader;

@Repository
public interface CallSlipRepository extends JpaRepository<callSlip, Long> {
	@Modifying
    @Query("UPDATE callSlip c SET c.status = true , c.returnDate = ?2 WHERE c.idCallSlip = ?1")
    int updateReturnDate(Long id, Date returnDate);
	
	@Query("SELECT c FROM callSlip c WHERE "+
			 "c.idCallSlip LIKE CONCAT('%', :query, '%')")
	List<callSlip> findByCriteria(String query);
	
}
