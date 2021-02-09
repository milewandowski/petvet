package com.lewandowski.service;

import com.lewandowski.entity.User;

public interface UserService {
    User findUserByUsername(String username);
}
