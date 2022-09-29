package com.library.service.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.entity.callSlip;
import com.library.entity.reader;
import com.library.repository.CallSlipRepository;
import com.library.repository.ReaderRepository;
import com.library.service.CallSlipService;

@Service
public class CallSlipServiceImpl implements CallSlipService {
	@Autowired
	private CallSlipRepository callSlipRepository;
	

    @Override
    public callSlip save(callSlip callSlip) {
        return callSlipRepository.save(callSlip);
    }
    
  

    public CallSlipServiceImpl(CallSlipRepository callSlipRepository) {
        this.callSlipRepository = callSlipRepository;
    }

    @Override
    public List<callSlip> findByCriteria (String query) {
        List<callSlip> callSlips = callSlipRepository.findByCriteria(query);
        return callSlips;
    }
	
//	 @Override
//	    public  Optional<callSlip> findById(Long id) {
//		
//	        return callSlipRepository.findById(id);
//	    }
    @Override
    public void returnBooks(Long callSlipId, Date returnDate) {
        callSlipRepository.updateReturnDate(callSlipId, returnDate);
       
    }

}
