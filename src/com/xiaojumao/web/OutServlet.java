package com.xiaojumao.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 10:02
 * @Modified By:
 */
@WebServlet(urlPatterns = "/OutServlet")
public class OutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        // 2.调取Service层方法
        // 3.跳转页面
        req.getSession().invalidate();
        resp.setContentType("text/html; charset=utf-8;");
        resp.getWriter().print("<script>alert('退出成功');top.location.href='login.jsp';</script>");
    }
}
