package com.jackiezz.blog.service.impl;

import com.jackiezz.blog.dao.UserDao;
import com.jackiezz.blog.dao.impl.UserDaoImpl;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public User login(User user) {
        return dao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
