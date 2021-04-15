package com.xiaojumao.web;

import com.xiaojumao.bean.Student;
import com.xiaojumao.service.imp.StudentServiceImp;

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
 * @Date Created in 2021-04-14 22:11
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/EditGetStu")
public class EditGetStu extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        Integer stuId = Integer.parseInt(req.getParameter("stuId"));

        // 2.调取service方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        // 根据stuId查找对应的Student
        Student studentByStuId = studentServiceImp.getStudentByStuId(stuId);

        // 3.跳转页面
        req.setAttribute("stu", studentByStuId);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}
