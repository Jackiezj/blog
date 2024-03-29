package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.ResultInfo;
import com.jackiezz.blog.domain.User;
import com.jackiezz.blog.service.UserService;
import com.jackiezz.blog.service.impl.UserServiceImpl;
import com.jackiezz.blog.util.MailUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Random;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    // 准备数据
    private ResultInfo info = new ResultInfo();
    private UserService userService = new UserServiceImpl();

    public void getLoginUser(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        writeValue(user, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) {
        ResultInfo info = new ResultInfo();
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 查询数据库
        User loginUser = userService.login(user);
        if (loginUser != null) {
            info.setFlag(true);
            info.setErrorMsg("登录成功");
            request.getSession().setAttribute("user", loginUser);
        } else {
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        writeValue(info, response);
    }

    public boolean checkUsername(HttpServletRequest request, HttpServletResponse response) {
        // 获取参数
        String username = request.getParameter("username");
        if (username == null) {
            info.setFlag(false);
            info.setErrorMsg("请传入正确的参数username");
            writeValue(info, response);
            return false;
        }

        // 与数据库交互
        if (checkUsernameDemo(username)) {
            writeValue(info, response);
            return false;
        } else {
            writeValue(info, response);
            return true;
        }
    }

    public boolean checkUsernameDemo(String username) {
        // 与数据库交互
        User user = userService.findByUsername(username);
        if (user != null) {
            info.setFlag(false);
            info.setErrorMsg("用户名已经存在,请更换");
            return false;
        } else {
            info.setFlag(true);
            info.setErrorMsg("用户名可以使用");
        }
        return true;
    }

    public void register (HttpServletRequest request, HttpServletResponse response) {
        // 获取参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String emailCode = request.getParameter("emailCode");
        // 校验参数
        if (username == null || username.length() < 6 || !checkUsernameDemo(username) || !checkEmailDemo(email)) {
            info.setFlag(false);
            info.setErrorMsg("用户名或邮箱不合法");
            writeValue(info, response);
            return;
        }

        Object realEmailCode = request.getSession().getAttribute("emailCode");
        request.getSession().removeAttribute("emailCode");
        if (realEmailCode == null || !realEmailCode.equals(emailCode)) {
            info.setFlag(false);
            info.setErrorMsg("验证码不正确");
            writeValue(info, response);
            return;
        }

        // 与数据库交互
        User user = new User();
        try {
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        userService.addUser(user);

        // 返回响应
        writeValue(info, response);

    }

    public boolean checkEmail(HttpServletRequest request, HttpServletResponse response) {
        // 获取参数
        String email = request.getParameter("email");
        if (email == null) {
            info.setFlag(false);
            info.setErrorMsg("请传入正确的参数email");
            writeValue(info, response);
            return false;
        }
        // 与数据库交互
        if (checkEmailDemo(email)) {
            writeValue(info, response);
            return true;
        }
        return false;
    }

    public boolean checkEmailDemo (String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            info.setFlag(false);
            info.setErrorMsg("邮箱已经存在,请更换");
            return false;
        } else {
            info.setFlag(true);
            info.setErrorMsg("邮箱可以使用");
        }
        return true;
    }

    public void sendEmailCode(HttpServletRequest request, HttpServletResponse response) {
        // 接收参数
        String email = request.getParameter("email");
        // 发送邮件
        String code = String.valueOf((int)((Math.random()*9+1)*100000));
        try {
            MailUtils.sendMail(email, "欢迎注册, 您的验证码是:" + code + ", 请在30分钟内完成注册", "注册验证码");
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("发送失败");
            writeValue(info, response);
            return;
        }
        // 验证码保存redis
        request.getSession().setAttribute("emailCode", code);
        // 返回响应
        info.setFlag(true);
        info.setErrorMsg("发送成功");
        writeValue(info, response);

    }

}
