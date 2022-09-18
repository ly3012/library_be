package com.library.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.callSlip;
import com.library.repository.CallSlipRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class CallSlipController {

	@Autowired
	private CallSlipRepository CallSlipRepository;
	public List<callSlip> callSlips = new ArrayList<callSlip>();


	@GetMapping("/callSlips")
	public List<callSlip> getAll() {
		return CallSlipRepository.findAll();
	}
	
	@PostMapping("/callSlips")
	public callSlip create(@RequestBody callSlip callSlip) {
		return CallSlipRepository.save(callSlip);
	}

	@DeleteMapping("/callSlips/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		CallSlipRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/callSlips/{id}")
	public callSlip getReaderById(@PathVariable Long id) {
		return CallSlipRepository.findById(id).get();
	}
	
	@PutMapping("/callSlips")
	public callSlip updateReader(@RequestBody callSlip callSlip) {
		return CallSlipRepository.save(callSlip);
	}
}