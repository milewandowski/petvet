package com.lewandowski.repository;

import com.lewandowski.entity.User;

public interface UserRepository extends EntityRepository<User> {

    User findByUsername(String username);

}
