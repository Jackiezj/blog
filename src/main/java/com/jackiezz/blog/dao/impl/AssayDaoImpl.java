package com.jackiezz.blog.dao.impl;

import com.jackiezz.blog.dao.AssayDao;
import com.jackiezz.blog.domain.Assay;
import com.jackiezz.blog.util.JdbcUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AssayDaoImpl implements AssayDao {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());

    @Override
    public List<Assay> findAllAssayList(int uid) {
        String sql = "select * from assay where uid = ? order by updateTime desc";
        List<Assay> assayList = null;
        try {
            assayList = template.query(sql, new BeanPropertyRowMapper<Assay>(Assay.class), uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return assayList;
    }

    @Override
    public List<Assay> findAssayListByCategory(int cid) {
        String sql = "select * from assay where cid = ? order by updateTime desc";
        List<Assay> assayList = null;
        try {
             assayList = template.query(sql, new BeanPropertyRowMapper<Assay>(Assay.class), cid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return assayList;
    }

    @Override
    public Assay findByAid(String aid) {
        String sql = "select * from assay where id = ?";
        Assay assay = null;
        try {
            assay = template.query(sql, new BeanPropertyRowMapper<Assay>(Assay.class), aid).get(0);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return assay;
    }
}
