package com.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.entity.callSlip;
import com.library.repository.CallSlipRepository;
import com.library.service.CallSlipService;

@Service
public class CallSlipServiceImpl implements CallSlipService {
	@Autowired
	private CallSlipRepository callSlipRepository;
	

    @Override
    public callSlip save(callSlip callSlip) {
        return callSlipRepository.save(callSlip);
    }
	
//	 @Override
//	    public  Optional<callSlip> findById(Long id) {
//		
//	        return callSlipRepository.findById(id);
//	    }

}
