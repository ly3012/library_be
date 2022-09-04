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

import com.library.entity.reader;
import com.library.repository.readerRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class readerController {

	@Autowired
	private readerRepository readerRepository;
	public List<reader> readers = new ArrayList<reader>();


	@GetMapping("/readers")
	public List<reader> getAll() {
		return readerRepository.findAll();
	}
	
	@PostMapping("/readers")
	public reader create(@RequestBody reader reader) {
		return readerRepository.save(reader);
	}

	@DeleteMapping("/readers/{id}")
	public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable Long id) {
		readerRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	
	@GetMapping("/readers/{id}")
	public reader getReaderById(@PathVariable Long id) {
		return readerRepository.findById(id).get();
	}
	
	@PutMapping("/readers")
	public reader updateReader(@RequestBody reader reader) {
		return readerRepository.save(reader);
	}
}
