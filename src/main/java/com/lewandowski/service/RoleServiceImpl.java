package com.lewandowski.service;

import com.lewandowski.entity.Role;
import com.lewandowski.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    @Transactional
    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}
