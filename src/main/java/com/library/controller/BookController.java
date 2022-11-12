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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.response.ResponseMessage;
import com.library.entity.book;
import com.library.repository.BookRepository;
import com.library.service.BookService;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")

public class BookController {
	
	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;
	
	public List<book> books = new ArrayList<book>();


	@GetMapping("/books")
	public List<book> getAll() {
		return bookRepository.findAll();
	}
	@PostMapping("/books")
	public ResponseEntity<?> create(@RequestBody book book) {
		bookRepository.save(book);
		return new ResponseEntity<>(new ResponseMessage("Thêm thành công",book), HttpStatus.OK);
	}
	@DeleteMapping("/books")
	public ResponseEntity<?> deleteById(@RequestParam("id") Long id) {
				bookRepository.deleteById(id);
		return new ResponseEntity<>("Xóa thành công",HttpStatus.OK);
	}
	@PutMapping("/books")
	public ResponseEntity<?> updateBook(@RequestBody book book,@RequestParam("id") Long id) {
		book.setIdBook(id);
		return new ResponseEntity<>(new ResponseMessage("Sửa thành công",bookRepository.save(book)), HttpStatus.OK);
	}
	
	
	@GetMapping("/books/search")
    public ResponseEntity<List<book>> findBookByCriteria(@RequestParam("query") String query){
        return ResponseEntity.ok(bookService.findBookByCriteria(query));
    }
	
//	@PostMapping("/books")
//	public book create(@RequestBody book book) {
//		
//		return bookRepository.save(book);
//	}

	
	
	

	
	@GetMapping("/books/{id}")
	public book getBookById(@PathVariable Long id) {
		return bookRepository.findById(id).get();
	}
	
	
}
