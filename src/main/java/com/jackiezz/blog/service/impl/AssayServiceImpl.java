package com.jackiezz.blog.service.impl;

import com.jackiezz.blog.dao.AssayDao;
import com.jackiezz.blog.dao.CategoryDao;
import com.jackiezz.blog.dao.FieldDao;
import com.jackiezz.blog.dao.impl.AssayDaoImpl;
import com.jackiezz.blog.dao.impl.CategoryDaoImpl;
import com.jackiezz.blog.dao.impl.FieldDaoImpl;
import com.jackiezz.blog.domain.Assay;
import com.jackiezz.blog.service.AssayService;

import java.util.List;

public class AssayServiceImpl implements AssayService {
    private AssayDao assayDao = new AssayDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();
    private FieldDao fieldDao = new FieldDaoImpl();

    @Override
    public List<Assay> findAssayListByCategory(int cid) {
        return assayDao.findAssayListByCategory(cid);
    }

    @Override
    public List<Assay> findAllAssayList(int uid) {
        return assayDao.findAllAssayList(uid);
    }
}
