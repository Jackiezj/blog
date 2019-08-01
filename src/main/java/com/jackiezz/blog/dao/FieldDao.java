package com.jackiezz.blog.dao;

import com.jackiezz.blog.domain.Field;

import java.util.List;

public interface FieldDao {
    List<Field> findAll(String uid);
}
