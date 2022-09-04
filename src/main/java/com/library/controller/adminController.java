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

import com.library.entity.admin;
import com.library.repository.adminRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class adminController {

	@Autowired
	private adminRepository adminRepository;
	public List<admin> admins = new ArrayList<admin>();


	@GetMapping("/admins")
	public List<admin> getAll() {
		return adminRepository.findAll();
	}
	
	@PostMapping("/admins")
	public admin create(@RequestBody admin admin) {
		return adminRepository.save(admin);
	}

	@DeleteMapping("/admins/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		adminRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/admins/{id}")
	public admin getReaderById(@PathVariable Long id) {
		return adminRepository.findById(id).get();
	}
	
	@PutMapping("/admins")
	public admin updateReader(@RequestBody admin admin) {
		return adminRepository.save(admin);
	}
}
