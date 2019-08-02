package com.jackiezz.blog.service;

import com.jackiezz.blog.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll(String fid);
}
