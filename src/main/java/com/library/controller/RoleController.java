package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Role;
import com.library.repository.RoleRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class RoleController {
	@Autowired
	private RoleRepository RoleRepository;
	@GetMapping("/roles")
	public List<Role> getAll() {
		return RoleRepository.findAll();
	}

}
