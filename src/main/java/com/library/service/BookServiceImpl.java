package com.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.book;
import com.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	  private BookRepository bookRepository;

	    public BookServiceImpl(BookRepository productRepository) {
	        this.bookRepository = productRepository;
	    }

	    @Override
	    public List<book> findBookByCriteria (String query) {
	        List<book> books = bookRepository.findBookByCriteria(query);
	        return books;
	    }
}
