package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.Assay;
import com.jackiezz.blog.domain.Category;
import com.jackiezz.blog.domain.Field;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.service.AssayService;
import com.jackiezz.blog.service.CategoryService;
import com.jackiezz.blog.service.FieldService;
import com.jackiezz.blog.service.impl.AssayServiceImpl;
import com.jackiezz.blog.service.impl.CategoryServiceImpl;
import com.jackiezz.blog.service.impl.FieldServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/assay/*")
public class AssayServlet extends BaseServlet {
    private FieldService fieldService = new FieldServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private AssayService assayService = new AssayServiceImpl();

    /**
     * 根据request中传入的参数category查询对应的assayList
     * @param request
     * @param response
     */
    public void findAssayListByCategory(HttpServletRequest request, HttpServletResponse response) {
        // 获取参数category
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Assay> assayList = assayService.findAssayListByCategory(cid);
        writeValue(assayList, response);
    }

    public void findAssayListFirstVisit(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        Field field = null;
        if (user == null) {
            field = fieldService.findFirst(6);
        } else {
            field = fieldService.findFirst(user.getId());
        }
        Category category = categoryService.findFirst(field.getId());
        List<Assay> assayList = assayService.findAssayListByCategory(category.getId());
        writeValue(assayList, response);
    }

}
