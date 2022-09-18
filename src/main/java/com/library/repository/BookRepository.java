package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.book;

@Repository
public interface BookRepository extends JpaRepository<book, Long> {
	 Optional<book> findByName(String name);
	
	@Query("SELECT b FROM book b WHERE "+
			 "b.name LIKE CONCAT('%', :query, '%')" +
			 "Or b.author LIKE CONCAT('%', :query, '%')")
	List<book> findBookByCriteria(String query);
	
}
