package com.library.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.User;
import com.library.entity.book;
import com.library.repository.UserRepository;
import com.library.service.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class UserController {

	@Autowired
	private UserRepository UserRepository;
	@Autowired
	private UserService userService;
	public List<User> Users = new ArrayList<User>();


	@GetMapping("/users")
	public List<User> getAll() {
		return UserRepository.findAll();
	}
	
	@GetMapping("/users/search")
    public ResponseEntity<List<User>> findUserByCriteria(@RequestParam("query") String query){
        return ResponseEntity.ok(userService.findUserByCriteria(query));
    }


	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Long id) {
		UserRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/users/{id}")
	public User getReaderById(@PathVariable Long id) {
		return UserRepository.findById(id).get();
	}
	
	@PutMapping("/users")
	public User updateReader(@RequestBody User User) {
		return UserRepository.save(User);
	}
}
