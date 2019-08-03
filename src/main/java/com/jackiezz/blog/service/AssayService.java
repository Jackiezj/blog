package com.jackiezz.blog.service;

import com.jackiezz.blog.domain.Assay;

import java.util.List;

public interface AssayService {
    List<Assay> findAssayListByCategory(int category);

    List<Assay> findAllAssayList(int id);

    Assay assayDetail(String aid);

    void update(Assay assay);
}
