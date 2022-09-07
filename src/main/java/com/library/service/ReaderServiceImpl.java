package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.reader;
import com.library.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService {
	@Autowired
	private ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @Override
    public List<reader> findByCriteria (String query) {
        List<reader> readers = readerRepository.findByCriteria(query);
        return readers;
    }
}
