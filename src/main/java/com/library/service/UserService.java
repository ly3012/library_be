package com.library.service;

import java.util.Optional;

import com.library.entity.User;

public interface UserService {
    Optional<User> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    User save(User user);
}
