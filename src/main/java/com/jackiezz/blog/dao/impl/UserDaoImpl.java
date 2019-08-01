package com.jackiezz.blog.dao.impl;

import com.jackiezz.blog.dao.UserDao;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public void add(User user) {
        String sql = "insert into user (username, password, email) values (?, ?, ?)";
        try {
            template.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        String sql = "select * from user where username = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByEmail(String email) {
        User user = null;
        String sql = "select * from user where email = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), email);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        String sql = "select * from user where (username = ? or email = ?) and password = ?";
        try {
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, username, password);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }
}
