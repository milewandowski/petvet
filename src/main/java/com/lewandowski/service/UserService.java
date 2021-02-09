package com.lewandowski.service;

import com.lewandowski.entity.User;
import com.lewandowski.validation.UserValidator;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findUserByUsername(String username);
    void save(UserValidator userValidator);
}
