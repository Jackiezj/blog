package com.jackiezz.blog.service;

import com.jackiezz.blog.domain.Category;
import com.jackiezz.blog.domain.Field;

import java.util.List;

public interface CategoryService {
    List<Category> findAll(String fid);

    Category findFirst(int id);

    void addCategory(Category category);
}
