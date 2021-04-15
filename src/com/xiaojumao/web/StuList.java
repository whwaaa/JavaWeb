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
 * @Date Created in 2021-04-14 19:12
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/StuList")
public class StuList extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        // 1.1 获取模糊查参数
        String stuName = req.getParameter("stuName");
        String stuNo = req.getParameter("stuNo");
        String sex1 = req.getParameter("sex");
        int sex = -1;
        if(sex1!=null && sex1!="")
            sex = Integer.parseInt(sex1);
        // 1.2 获取分页参数
        String pageIndex1 = req.getParameter("pageIndex");
        int pageIndex = 1;
        if(pageIndex1!=null && pageIndex1!="")
            pageIndex = Integer.parseInt(pageIndex1);
        int pageSize = 5;

        // 2.调用service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        List<Student> studentMessage = studentServiceImp.getStudentMessage(stuName, stuNo, sex, pageIndex, pageSize);
        // 查询数据总条数
        int indexTotal = studentServiceImp.getIndexTotal(stuName, stuNo, sex);
        // 根据数据总条数和一页大小计算总页数
        int pageTotal = (int)Math.ceil((double) indexTotal / pageSize);

        // 3.跳转页面
        // 3.1 存储查询结果
        req.setAttribute("stuList", studentMessage);
        // 3.2 存储模糊查相关
        req.setAttribute("stuName", stuName);
        req.setAttribute("stuNo", stuNo);
        req.setAttribute("sex", sex);
        // 3.3 存储分页相关
        req.setAttribute("pageSize", pageSize);
        req.setAttribute("indexTotal", indexTotal);
        req.setAttribute("pageTotal", pageTotal);
        req.getSession().setAttribute("pageIndex", pageIndex);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
