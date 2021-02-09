package com.lewandowski.service;

import com.lewandowski.entity.Role;

public interface RoleService {
    Role findRoleByName(String roleName);
}
