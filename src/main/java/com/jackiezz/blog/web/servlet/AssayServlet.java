package com.jackiezz.blog.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/assay/*")
public class AssayServlet extends BaseServlet {
    private FieldService fieldService = new FieldServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    private AssayService assayService = new AssayServiceImpl();

    /**
     * 文章修改时自动保存
     * @param request
     * @param response
     */
    public void assaySave(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Assay assay = new Assay();
        assay.setId(Integer.parseInt(parameterMap.get("id")[0]));
        assay.setAname(parameterMap.get("aname")[0]);
        assay.setDigest(parameterMap.get("digest")[0]);
        assay.setContent(parameterMap.get("content")[0]);
        assay.setCid(Integer.parseInt(parameterMap.get("cid")[0]));
        assay.setCid(Integer.parseInt(parameterMap.get("uid")[0]));
        Date date = new Date();
        assay.setCreateTime(new Date(Long.valueOf(parameterMap.get("createTime")[0])));
        assay.setCreateTime(new Date(Long.valueOf(parameterMap.get("updateTime")[0])));
        assay.setLogo(parameterMap.get("logo")[0]);

        assayService.update(assay);
    }

    /**
     * 获取某个文章
     * @param request
     * @param response
     */
    public void assayDetail(HttpServletRequest request, HttpServletResponse response) {
        String aid = request.getParameter("aid");
        Assay assay = assayService.assayDetail(aid);
        writeValue(assay, response);
    }

    /**
     * 根据request中传入的参数category查询对应的assayList
     * @param request
     * @param response
     */
    public void findAllAssayListByUser(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            writeValue("", response);
        } else {
            List<Assay> assayList = assayService.findAllAssayList(user.getId());
            writeValue(assayList, response);
        }
    }


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
