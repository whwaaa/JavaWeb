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
 * @Date Created in 2021-04-15 10:42
 * @Modified By:
 */
@WebServlet(urlPatterns = "/Educational/student/DeleteStuServlet")
public class DeleteStuServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String stuId = req.getParameter("stuId");
        // 获取分页参数
        String pageIndex1 = req.getParameter("pageIndex");
        int pageIndex = 1;
        if(pageIndex1!=null && pageIndex1!="")
            pageIndex = Integer.parseInt(pageIndex1);

        // 2.调取service层方法
        // 根据stuId删除数据库信息
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        boolean b = studentServiceImp.deleteStuByStuId(stuId);

        // 3.跳转页面
        req.getRequestDispatcher("StuList?pageIndex" + pageIndex).forward(req, resp);
    }
}
