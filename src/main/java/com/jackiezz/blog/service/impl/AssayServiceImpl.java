package com.jackiezz.blog.service.impl;

import com.jackiezz.blog.dao.AssayDao;
import com.jackiezz.blog.dao.impl.AssayDaoImpl;
import com.jackiezz.blog.domain.Assay;
import com.jackiezz.blog.service.AssayService;

import java.util.List;

public class AssayServiceImpl implements AssayService {
    private AssayDao assayDao = new AssayDaoImpl();

    @Override
    public List<Assay> findAssayListByCategory(int cid) {
        return assayDao.findAssayListByCategory(cid);
    }
}
