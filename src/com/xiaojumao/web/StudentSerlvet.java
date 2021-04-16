package com.xiaojumao.web;

import com.xiaojumao.bean.Grade;
import com.xiaojumao.bean.Student;
import com.xiaojumao.service.imp.GradeServiceImp;
import com.xiaojumao.service.imp.StudentServiceImp;
import com.xiaojumao.utils.PageInfo;
import com.xiaojumao.utils.SexEnum;

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
 * @Date Created in 2021-04-16 12:06
 * @Modified By:
 */
@WebServlet(urlPatterns = {"/Educational/student/AddStuServlet",
        "/Educational/student/DeleteStuServlet",
        "/Educational/student/EditGetStu",
        "/Educational/student/EditServlet",
        "/Educational/student/StuList",
        "/Educational/student/CkeckStuNo",
        "/Educational/student/CheckEmail",
        "/Educational/student/CkeckPhone",
        "/Educational/student/CkeckIdNumber"})
public class StudentSerlvet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.endsWith("AddStuServlet")){
            AddStuServlet(req, resp);
        }else if(uri.endsWith("DeleteStuServlet")){
            DeleteStuServlet(req, resp);
        }else if(uri.endsWith("EditGetStu")){
            EditGetStu(req, resp);
        }else if(uri.endsWith("EditServlet")){
            EditServlet(req, resp);
        }else if(uri.endsWith("StuList")){
            StuList(req, resp);
        }else if(uri.endsWith("CkeckStuNo")){
            CkeckStuNo(req, resp);
        }else if(uri.endsWith("CheckEmail")){
            CheckEmail(req, resp);
        }else if(uri.endsWith("CkeckPhone")){
            CkeckPhone(req, resp);
        }else if(uri.endsWith("CkeckIdNumber")){
            CkeckIdNumber(req, resp);
        }

    }

    /**
     * 添加学生信息
     */
    protected void AddStuServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 删除学生信息
     */
    protected void DeleteStuServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String stuId = req.getParameter("stuId");

        // 2.调取service层方法
        // 根据stuId删除数据库信息
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        boolean b = studentServiceImp.deleteStuByStuId(stuId);

        // 3.跳转页面
        req.getRequestDispatcher("StuList").forward(req, resp);
    }

    /**
     * 获得要修改的学生信息
     */
    protected void EditGetStu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        Integer stuId = Integer.parseInt(req.getParameter("stuId"));
        // 获取分页参数
        PageInfo pageInfo = new PageInfo();
        String pageIndex1 = req.getParameter("pageIndex");
        pageInfo.setPageIndex(1);
        if(pageIndex1!=null && pageIndex1!="")
            pageInfo.setPageIndex(Integer.parseInt(pageIndex1));

        // 2.调取service方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        // 根据stuId查找对应的Student
        Student studentByStuId = studentServiceImp.getStudentByStuId(stuId);
        // 获取年级信息
        GradeServiceImp gradeServiceImp = new GradeServiceImp();
        List<Grade> grade = gradeServiceImp.getGrade();

        // 3.跳转页面
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("stu", studentByStuId);
        req.setAttribute("grade", grade);
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }

    /**
     * 修改学生信息
     */
    protected void EditServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    /**
     * 显示学生信息
     */
    protected void StuList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        // 1.1 获取模糊查参数
        PageInfo pageInfo = new PageInfo();
        pageInfo.setStuName(req.getParameter("stuName"));
        pageInfo.setStuNo(req.getParameter("stuNo"));
        String sex1 = req.getParameter("sex");
        pageInfo.setSex(SexEnum.NOTSPECIFIED.type);
        if(sex1!=null && sex1!="")
            pageInfo.setSex(Integer.parseInt(sex1));
        // 1.2 获取分页参数
        String pageIndex1 = req.getParameter("pageIndex");
        pageInfo.setPageIndex(1);
        if(pageIndex1!=null && pageIndex1!="")
            pageInfo.setPageIndex(Integer.parseInt(pageIndex1));
        pageInfo.setPageSize(5);

        // 2.调用service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        List<Student> studentMessage = studentServiceImp.getStudentMessage(pageInfo.getStuName(),
                pageInfo.getStuNo(), pageInfo.getSex(), pageInfo.getPageIndex(), pageInfo.getPageSize());
        pageInfo.setStuList(studentMessage);
        // 查询数据总条数
        pageInfo.setIndexTotal(studentServiceImp.getIndexTotal(pageInfo.getStuName(), pageInfo.getStuNo(), pageInfo.getSex()));

        // 3.跳转页面
        // 存储pageInfo
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    /**
     * 学号检查
     */
    protected void CkeckStuNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String stuNo = req.getParameter("stuNo");
        // 2.调用service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        Student student = studentServiceImp.checkStuByStuNo(stuNo);

        // 3.发送数据
        resp.setContentType("text/html; charset=utf-8;");
        if(student != null){
            // 学号重复
            resp.getWriter().print("exist");
        }else{
            resp.getWriter().print("ok");
        }
    }

    /**
     * 邮箱检查
     */
    protected void CheckEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String email = req.getParameter("email");
        // 2.调用service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        Student student = studentServiceImp.checkStuByEmail(email);

        // 3.发送数据
        resp.setContentType("text/html; charset=utf-8;");
        if(student != null){
            // 学号重复
            resp.getWriter().print("exist");
        }else{
            resp.getWriter().print("ok");
        }
    }

    /**
     * 手机号检查
     */
    protected void CkeckPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String phone = req.getParameter("phone");
        // 2.调用service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        Student student = studentServiceImp.checkStuByPhone(phone);

        // 3.发送数据
        resp.setContentType("text/html; charset=utf-8;");
        if(student != null){
            // 学号重复
            resp.getWriter().print("exist");
        }else{
            resp.getWriter().print("ok");
        }
    }

    /**
     * 身份证号检查
     */
    protected void CkeckIdNumber(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取参数
        String idNumber = req.getParameter("idNumber");
        // 2.调用service层方法
        StudentServiceImp studentServiceImp = new StudentServiceImp();
        Student student = studentServiceImp.checkStuByIdNumber(idNumber);

        // 3.发送数据
        resp.setContentType("text/html; charset=utf-8;");
        if(student != null){
            // 学号重复
            resp.getWriter().print("exist");
        }else{
            resp.getWriter().print("ok");
        }
    }
}
