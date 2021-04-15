package com.xiaojumao.service;

import com.xiaojumao.bean.Student;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface StudentService {

    /**
     * 获取学生信息
     * @return
     */
    public List<Student> getStudentMessage(String stuName, String stuNo, int sex, int pageIndex, int pageSize);

    /**
     * 根据学生id查找学生信息
     * @return
     */
    public Student getStudentByStuId(Integer stuId);

    /**
     * 跟新数据库信息
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 根据stuId查找Student
     * @param stuId
     * @param stuList
     * @return
     */
    public Student findStudentByStuId(Integer stuId, List<Student> stuList);

    /**
     * 更新session中的student信息
     * @param student
     * @param stuList
     * @return
     */
    public List<Student> updateSessionStu(Student student, List<Student> stuList);

    /**
     * 根据stuId删除数据库的学生信息
     * @param stuId
     * @return
     */
    public boolean deleteStuByStuId(String stuId);

    /**
     * 根据stuId删除session的学生信息
     * @param stuId
     * @return
     */
    public boolean deleteSessionStuByStuId(String stuId, List<Student> sessionList);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    public boolean addStudent(Student student);

    /**
     * 计算总页数
     * @param stuName
     * @param stuNo
     * @param sex
     * @return
     */
    public int getIndexTotal(String stuName, String stuNo, int sex);
}
