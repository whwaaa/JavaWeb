package com.xiaojumao.web;

import com.xiaojumao.bean.Users;
import com.xiaojumao.service.imp.UsersServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 22:53
 * @Modified By:
 */
@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 2.调取service层方法
        UsersServiceImp usersServiceImp = new UsersServiceImp();
        Users users = usersServiceImp.loginVerfi(username, password);

        // 3.跳转页面
        resp.setContentType("text/html; charset=utf-8;");
        if(users != null){
            // 验证成功
            resp.sendRedirect("index.jsp");
        }else{
            // 验证失败
            resp.getWriter().print("<script>alert('用户名或密码错误, 登录失败!');window.location.href='login.jsp';</script>");
        }
    }
}
