package com.library.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.book;
import com.library.repository.BookRepository;


@RestController
@RequestMapping("/admin/book")

public class bookController {

	@Autowired
	private BookRepository bookRepository;
	public List<book> books = new ArrayList<book>();


	@GetMapping("/list")
	public List<book> getAll() {
		return bookRepository.findAll();
	}
	
	@PostMapping("/add")
	public book create(@RequestBody book book) {
		books.add(book);
		this.bookRepository.save(book);
		return book;
	}


	@DeleteMapping("/delete")
	public void delete(@RequestParam(name = "idBook") int idBook) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIdBook() == (idBook)) {
				books.remove(i);
				break;
			}
		}
	}

	@PutMapping("/edit")
	public void update(@RequestBody book book) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIdBook() == (book.getIdBook())) {
				books.set(i, book);
				break;
			}
		}
	}

}
