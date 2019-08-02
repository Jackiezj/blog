package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.Category;
import com.jackiezz.blog.service.CategoryService;
import com.jackiezz.blog.service.impl.CategoryServiceImpl;
import com.sun.xml.internal.rngom.parse.host.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();
    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        String fid = request.getParameter("fid");
        List<Category> categoryList = service.findAll(fid);
        writeValue(categoryList, response);
    }

}
