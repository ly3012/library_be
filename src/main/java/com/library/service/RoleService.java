package com.library.service;

import java.util.Optional;

import com.library.entity.Role;
import com.library.entity.RoleName;

public interface RoleService {
    Optional<Role> findByName(RoleName name);
}
