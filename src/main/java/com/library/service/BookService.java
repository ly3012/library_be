package com.library.service;

import java.util.List;

import com.library.entity.book;

public interface BookService {
	 List<book> findBookByCriteria(String query);
}
