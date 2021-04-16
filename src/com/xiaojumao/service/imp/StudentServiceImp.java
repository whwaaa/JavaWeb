package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Student;
import com.xiaojumao.dao.imp.StudentDaoImp;
import com.xiaojumao.service.StudentService;

import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public class StudentServiceImp implements StudentService {

    StudentDaoImp studentDaoImp = new StudentDaoImp();

    @Override
    public List<Student> getStudentMessage(String stuName, String stuNo, int sex, int pageIndex, int pageSize) {
        return studentDaoImp.getStudentMessage(stuName, stuNo, sex, pageIndex, pageSize);
    }

    @Override
    public Student getStudentByStuId(Integer stuId) {
        return studentDaoImp.getStudentByStuId(stuId);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDaoImp.updateStudent(student);
    }

    @Override
    public boolean deleteStuByStuId(String stuId) {
        int i = studentDaoImp.deleteStuByStuId(stuId);
        if(i>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addStudent(Student student) {
        int i = studentDaoImp.addStudent(student);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public int getIndexTotal(String stuName, String stuNo, int sex) {
        return studentDaoImp.getPageIndexTotal(stuName, stuNo, sex);
    }

    @Override
    public Student checkStuByStuNo(String stuNo) {
        return studentDaoImp.checkStuByStuNo(stuNo);
    }

    @Override
    public Student checkStuByEmail(String email) {
        return studentDaoImp.checkStuByEmail(email);
    }

    @Override
    public Student checkStuByPhone(String phone) {
        return studentDaoImp.checkStuByPhone(phone);
    }

    @Override
    public Student checkStuByIdNumber(String idNumber) {
        return studentDaoImp.checkStuByIdNumber(idNumber);
    }


}
