package com.xiaojumao.web;

import com.xiaojumao.bean.Grade;
import com.xiaojumao.service.imp.GradeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-16 11:55
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/GetGradeServlet")
public class GetGradeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取年级信息
        GradeServiceImp gradeServiceImp = new GradeServiceImp();
        List<Grade> grade = gradeServiceImp.getGrade();
        // 获取分页参数
        String pageIndex1 = req.getParameter("pageIndex");
        int pageIndex = 1;
        if(pageIndex1!=null && pageIndex1!="")
            pageIndex = Integer.parseInt(pageIndex1);
        // 跳转页面
        req.setAttribute("grade", grade);
        req.setAttribute("pageIndex", pageIndex);
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
}
