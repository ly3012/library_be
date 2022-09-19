package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.User;
import com.library.entity.book;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    
    @Query("SELECT u FROM User u WHERE "+
			 "u.name LIKE CONCAT('%', :query, '%')" )
//    		+ "Or u.email LIKE CONCAT('%', :query, '%')")
	List<User> findUserByCriteria(String query);
}