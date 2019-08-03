package com.jackiezz.blog.dao.impl;

import com.jackiezz.blog.dao.AssayDao;
import com.jackiezz.blog.domain.Assay;
import com.jackiezz.blog.util.JdbcUtils;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
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

    @Override
    public void update(Assay assay) {
        String sql = "update assay set aname=?, digest=?, content=?, updateTime=? where id=?";
        try {
            template.update(sql, assay.getAname(), assay.getDigest(), assay.getContent(), assay.getUpdateTime(), assay.getId());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addAssay(Assay assay) {
        String sql = "insert into assay (aname, digest, content, cid, uid, createTime, updateTime, logo) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            template.update(sql, assay.getAname(), assay.getDigest(), assay.getContent(), assay.getCid(), assay.getUid(), assay.getCreateTime(), assay.getUpdateTime(), assay.getLogo());
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
