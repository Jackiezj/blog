package com.jackiezz.blog.service.impl;

import com.jackiezz.blog.dao.FieldDao;
import com.jackiezz.blog.dao.impl.FieldDaoImpl;
import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.service.FieldService;

import java.util.List;

public class FieldServiceImpl implements FieldService {
    private FieldDao dao = new FieldDaoImpl();

    @Override
    public List<Field> findAll(String uid) {
        return dao.findAll(uid);
    }

    @Override
    public Field findFirst(int id) {
        return dao.findFirst(id);
    }
}
