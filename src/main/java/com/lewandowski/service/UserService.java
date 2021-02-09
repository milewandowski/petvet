package com.lewandowski.service;

import com.lewandowski.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findUserByUsername(String username);
}
