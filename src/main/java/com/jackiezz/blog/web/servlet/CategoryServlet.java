package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.Category;
import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.service.CategoryService;
import com.jackiezz.blog.service.FieldService;
import com.jackiezz.blog.service.impl.CategoryServiceImpl;
import com.jackiezz.blog.service.impl.FieldServiceImpl;
import com.sun.xml.internal.rngom.parse.host.Base;
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

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service = new CategoryServiceImpl();
    private FieldService fieldService = new FieldServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) {
        String fid = request.getParameter("fid");
        // 如果是fid==0 首次访问首页时加载用户第一个分类的数据
        if ("0".equals(fid)) {
            User user = (User) request.getSession().getAttribute("user");
            if (user != null) {
                Field field = fieldService.findFirst(user.getId());
                fid = String.valueOf(field.getId());
            } else {
                fid = "1";
            }
        }
        List<Category> categoryList = service.findAll(fid);
        writeValue(categoryList, response);
    }

    /**
     * 新增分类
     * @param request
     * @param response
     */
    public void addCategory(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Category category = new Category();
        try {
            BeanUtils.populate(category, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        service.addCategory(category);
    }

}
