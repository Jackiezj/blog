package com.jackiezz.blog.service;

import com.jackiezz.blog.domain.Field;

import java.util.List;

public interface FieldService {
    List<Field> findAll(String uid);
}
