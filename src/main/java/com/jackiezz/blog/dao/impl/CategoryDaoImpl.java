package com.jackiezz.blog.dao.impl;

import com.jackiezz.blog.dao.CategoryDao;
import com.jackiezz.blog.domain.Category;
import com.jackiezz.blog.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public List<Category> findAll(String fid) {
        String sql = "select * from category where fid = ?";
        return template.query(sql, new BeanPropertyRowMapper<Category>(Category.class), fid);
    }

    @Override
    public Category findFirst(int id) {
        String sql = "select * from category where fid = ? limit 0, 1";
        List<Category> category = null;
        try {
            category = template.query(sql, new BeanPropertyRowMapper<Category>(Category.class), id);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return category.get(0);
    }
}
