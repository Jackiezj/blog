package com.jackiezz.blog.dao.impl;

import com.jackiezz.blog.dao.FieldDao;
import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FieldDaoImpl implements FieldDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Field> findAll(String uid) {
        String sql = "select * from field where uid = ?";
        List<Field> fieldList = template.query(sql, new BeanPropertyRowMapper<Field>(Field.class), uid);
        return fieldList;
    }
}
