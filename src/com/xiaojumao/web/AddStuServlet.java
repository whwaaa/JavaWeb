package com.xiaojumao.web;

import com.xiaojumao.bean.Student;
import com.xiaojumao.service.imp.StudentServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Date;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-15 11:42
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/AddStuServlet")
public class AddStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        Student student = new Student();
        student.setSex(Integer.parseInt(req.getParameter("sex")));
        student.setStuName(req.getParameter("stuName"));
        student.setStuNo(req.getParameter("stuNo"));
        student.setGid(Integer.parseInt(req.getParameter("gid")));
        student.setEmail(req.getParameter("email"));
        student.setPhone(req.getParameter("phone"));
        student.setRegistered(req.getParameter("registered"));
        student.setAddress(req.getParameter("address"));
        student.setPolitics(req.getParameter("politics"));
        student.setIdNumber(req.getParameter("idNumber"));
        student.setProfession(req.getParameter("profession"));
        student.setIntroduction(req.getParameter("introduction"));
        // 获取当前日期
        student.setRegDate(new Date(System.currentTimeMillis()));
        // 获取分页参数
        String pageIndex1 = req.getParameter("pageIndex");
        int pageIndex = 1;
        if(pageIndex1!=null && pageIndex1!="")
            pageIndex = Integer.parseInt(pageIndex1);
        int pageSize = 5;

        // 2.调取service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        boolean b = studentServiceImp.addStudent(student);

        // 3.跳转页面
        resp.setContentType("text/html; charset=utf-8;");
        if(b){
            resp.getWriter().print("<script>alert('添加成功');window.location.href='StuList?pageIndex=" + pageIndex + "';</script>");
        }else{
            resp.getWriter().print("<script>alert('数据库故障添加失败');window.location.href='StuList?pageIndex=" + pageIndex + "';</script>");
        }
    }
}
