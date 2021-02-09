package com.lewandowski.repository;

import com.lewandowski.entity.Role;

public interface RoleRepository extends EntityRepository<Role> {
    Role findRoleByName(String roleName);
}
