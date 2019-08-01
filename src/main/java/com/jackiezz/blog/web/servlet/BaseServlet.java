package com.jackiezz.blog.web.servlet;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 所有的Servlet都由BaseServlet实现路由分发
 * 所有Servlet
 *  定义方法: @WebServlet("/xxx/*")
 *  定义函数, 路由如: /xxx/addUser将自动执行Servlet中的addUser函数
 */
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取路径地址  /userServlet/addUser
        String path = req.getRequestURI();  // /user/addUser
        String lastPath = path.substring(path.lastIndexOf("/") + 1);

        // 获取对应方法并执行
        Class<? extends BaseServlet> cls = this.getClass();
        try {
            Method method = cls.getMethod(lastPath, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象序列化为json写回客户端
     * @param obj
     * @param response
     * @throws IOException
     */
    public void writeValue (Object obj, HttpServletResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        try {
            mapper.writeValue(response.getOutputStream(), obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将对象序列化为json字符串
     * @param obj
     * @return
     */
    public String writeValueAsString (Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }



}
