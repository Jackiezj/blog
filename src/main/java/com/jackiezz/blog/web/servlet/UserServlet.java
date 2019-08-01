package com.jackiezz.blog.web.servlet;

import com.jackiezz.blog.domain.ResultInfo;
import com.jackiezz.blog.util.MailUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {
    public void register (HttpServletRequest request, HttpServletResponse response) {

    }

    public void sendEmailCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ResultInfo info = new ResultInfo();
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
