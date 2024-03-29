package com.jackiezz.blog.service;

import com.jackiezz.blog.domain.User;

public interface UserService {
    void addUser(User user);

    User findByUsername(String username);

    User findByEmail(String email);

    User login(User user);
}
