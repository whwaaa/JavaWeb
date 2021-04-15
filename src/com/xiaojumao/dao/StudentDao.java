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
     * @return
     */
    public List<Student> getStudentMessage(String stuName, String stuNo, int sex, int pageIndex, int pageSize);

    /**
     * 获取查询数据的总条数
     * @param stuName
     * @param stuNo
     * @param sex
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public int getPageIndexTotal(String stuName, String stuNo, int sex);

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
     * 根据stuId删除数据库的学生信息
     * @param stuId
     * @return
     */
    public int deleteStuByStuId(String stuId);

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    public int addStudent(Student student);
}
