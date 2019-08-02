package com.jackiezz.blog.dao;

import com.jackiezz.blog.domain.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll(String fid);
}
