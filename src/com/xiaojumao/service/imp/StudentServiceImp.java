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
    public Student findStudentByStuId(Integer stuId, List<Student> stuList) {
        for (Student student : stuList) {
            if(student.getStuId().equals(stuId)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> updateSessionStu(Student student, List<Student> stuList) {
        for (Student listStu : stuList) {
            if(listStu.getStuId().equals(student.getStuId())){
                // 更新操作
                listStu.setStuNo(student.getProfession());
                listStu.setStuName(student.getStuNo());
                listStu.setGid(student.getGid());
                listStu.setSex(student.getSex());
                listStu.setEmail(student.getEmail());
                listStu.setPhone(student.getPhone());
                listStu.setRegistered(student.getRegistered());
                listStu.setAddress(student.getAddress());
                listStu.setPolitics(student.getPolitics());
                listStu.setIdNumber(student.getIdNumber());
                listStu.setProfession(student.getProfession());
                break;
            }
        }
        return stuList;
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
    public boolean deleteSessionStuByStuId(String stuId, List<Student> sessionList) {
        for (Student student : sessionList) {
            if(student.getStuId().equals(Integer.parseInt(stuId))){
                sessionList.remove(student);
                return true;
            }
        }
        return false;
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


}
