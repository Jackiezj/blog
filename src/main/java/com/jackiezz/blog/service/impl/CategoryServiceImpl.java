package com.jackiezz.blog.service.impl;

import com.jackiezz.blog.dao.CategoryDao;
import com.jackiezz.blog.dao.impl.CategoryDaoImpl;
import com.jackiezz.blog.domain.Category;
import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll(String fid) {
        return dao.findAll(fid);
    }

    @Override
    public Category findFirst(int id) {
        return dao.findFirst(id);
    }

    @Override
    public void addCategory(Category category) {
        dao.addCategory(category);
    }
}
