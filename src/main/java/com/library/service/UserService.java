package com.library.service;

import java.util.List;
import java.util.Optional;

import com.library.entity.User;
import com.library.entity.book;

public interface UserService {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User save(User user);
    
    List<User> findUserByCriteria(String query);
}
