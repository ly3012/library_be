package com.library.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Role;
import com.library.entity.RoleName;
import com.library.repository.RoleRepository;
import com.library.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
