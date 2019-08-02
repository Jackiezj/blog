package com.jackiezz.blog.dao.impl;

import com.jackiezz.blog.dao.FieldDao;
import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
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

    @Override
    public Field findFirst(int id) {
        String sql = "select * from field where uid = ? limit 0, 1";
        Field field = null;
        try {
            List<Field> list = template.query(sql, new BeanPropertyRowMapper<Field>(Field.class), id);
            field = list.get(0);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return field;
    }
}
