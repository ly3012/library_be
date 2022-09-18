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

import com.library.entity.Admin;
import com.library.repository.AdminRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminRepository AdminRepository;
	public List<Admin> Admins = new ArrayList<Admin>();


	@GetMapping("/admins")
	public List<Admin> getAll() {
		return AdminRepository.findAll();
	}
	
	@PostMapping("/admins")
	public Admin create(@RequestBody Admin Admin) {
		return AdminRepository.save(Admin);
	}

	@DeleteMapping("/admins/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		AdminRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/admins/{id}")
	public Admin getReaderById(@PathVariable Long id) {
		return AdminRepository.findById(id).get();
	}
	
	@PutMapping("/admins")
	public Admin updateReader(@RequestBody Admin Admin) {
		return AdminRepository.save(Admin);
	}
}
