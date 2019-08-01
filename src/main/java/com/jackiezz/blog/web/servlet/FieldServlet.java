package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.service.FieldService;
import com.jackiezz.blog.service.impl.FieldServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/field/*")
public class FieldServlet extends BaseServlet {
    private FieldService fieldService = new FieldServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        User loginUser = (User)request.getSession().getAttribute("user");
        String uid = loginUser != null ? String.valueOf(loginUser.getId()) : "6";
        List<Field> fieldList = fieldService.findAll(uid);
        writeValue(fieldList, response);
    }
}
