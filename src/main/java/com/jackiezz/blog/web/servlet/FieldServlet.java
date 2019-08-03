package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.service.FieldService;
import com.jackiezz.blog.service.impl.FieldServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/field/*")
public class FieldServlet extends BaseServlet {
    private FieldService fieldService = new FieldServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        User loginUser = (User)request.getSession().getAttribute("user");
        String uid = loginUser != null ? String.valueOf(loginUser.getId()) : "6";
        List<Field> fieldList = fieldService.findAll(uid);
        writeValue(fieldList, response);
    }

    /**
     * 增加领域
     * @param request
     * @param response
     */
    public void addField(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = (User) request.getSession().getAttribute("user");
        Field field = new Field();
        field.setUid(user.getId());
        try {
            BeanUtils.populate(field, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        fieldService.addField(field);
    }
}
