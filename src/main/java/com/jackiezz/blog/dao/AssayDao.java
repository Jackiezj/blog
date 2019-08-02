package com.jackiezz.blog.dao;

import com.jackiezz.blog.domain.Assay;

import java.util.List;

public interface AssayDao {
    List<Assay> findAllAssayList(int uid);

    List<Assay> findAssayListByCategory(int category);
}
