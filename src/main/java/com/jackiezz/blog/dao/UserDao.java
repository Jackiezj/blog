package com.jackiezz.blog.dao;

import com.jackiezz.blog.domain.User;

public interface UserDao {
    void add(User user);

    User findByUsername(String username);

    User findByEmail(String email);
}
