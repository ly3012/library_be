package com.library.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.library.entity.callSlip;
import com.library.entity.reader;

public interface CallSlipService {
//	Optional<callSlip> findById(Long id);

	callSlip save(callSlip callSlip);
	@Transactional
	void returnBooks(Long callSlipId, Date returnDate) ;
	
	 List<callSlip> findByCriteria(String query);

//	List<callSlip> findUserByQuery(String query);

}
