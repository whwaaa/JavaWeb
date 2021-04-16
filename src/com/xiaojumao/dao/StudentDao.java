package com.xiaojumao.dao;

import com.xiaojumao.bean.Student;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface StudentDao {
    /**
     * 获取学生信息
     */
    public List<Student> getStudentMessage(String stuName, String stuNo, int sex, int pageIndex, int pageSize);

    /**
     * 获取查询数据的总条数
     */
    public int getPageIndexTotal(String stuName, String stuNo, int sex);

    /**
     * 根据学生id查找学生信息
     */
    public Student getStudentByStuId(Integer stuId);

    /**
     * 跟新数据库信息
     */
    public int updateStudent(Student student);

    /**
     * 根据stuId删除数据库的学生信息
     */
    public int deleteStuByStuId(String stuId);

    /**
     * 添加学生信息
     */
    public int addStudent(Student student);

    /**
     * 根据学号查询学生信息
     */
    public Student checkStuByStuNo(String stuNo);

    /**
     * 根据邮箱查询学生信息
     */
    public Student checkStuByEmail(String email);

    /**
     * 根据联系电话查询学生信息
     */
    public Student checkStuByPhone(String phone);

    /**
     * 根据身份证号查询学生信息
     */
    public Student checkStuByIdNumber(String idNumber);
}
