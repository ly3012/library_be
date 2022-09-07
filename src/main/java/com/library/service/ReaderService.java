package com.library.service;

import java.util.List;

import com.library.entity.reader;

public interface ReaderService {
	 List<reader> findByCriteria(String query);

}
