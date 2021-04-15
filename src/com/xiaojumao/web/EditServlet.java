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
 * @Date Created in 2021-04-14 20:51
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/EditServlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        Student student = new Student();
        student.setStuId(Integer.parseInt(req.getParameter("stuId")));
        student.setStuNo(req.getParameter("stuNo"));
        student.setStuName(req.getParameter("stuName"));
        student.setGid(Integer.parseInt(req.getParameter("gid")));
        student.setSex(Integer.parseInt(req.getParameter("sex")));
        student.setEmail(req.getParameter("email"));
        student.setPhone(req.getParameter("phone"));
        student.setRegistered(req.getParameter("registered"));
        student.setAddress(req.getParameter("address"));
        student.setPolitics(req.getParameter("politics"));
        student.setIdNumber(req.getParameter("idNumber"));
        student.setProfession(req.getParameter("profession"));
        // 获取分页参数
        String pageIndex1 = req.getParameter("pageIndex");
        int pageIndex = 1;
        if(pageIndex1!=null && pageIndex1!="")
            pageIndex = Integer.parseInt(pageIndex1);

        // 2.调取service方法
        // 更新数据库信息
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        int i = studentServiceImp.updateStudent(student);
        resp.setContentType("text/html; charset=utf-8;");
        if(i > 0){
            // 3.跳转页面
            resp.getWriter().print("<script>alert('修改成功');window.location.href='StuList?pageIndex=" + pageIndex + "';</script>");
        }else{
            resp.getWriter().print("<script>alert('修改失败');window.location.href='StuList?pageIndex=" + pageIndex + "';</script>");
        }
    }
}
