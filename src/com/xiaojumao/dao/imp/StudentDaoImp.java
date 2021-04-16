package com.xiaojumao.dao.imp;

import com.xiaojumao.bean.Student;
import com.xiaojumao.dao.DBUtils;
import com.xiaojumao.dao.StudentDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:56
 * @Modified By:
 */

public class StudentDaoImp extends DBUtils implements StudentDao {

    @Override
    public int getPageIndexTotal(String stuName, String stuNo, int sex) {
        StringBuilder sql = new StringBuilder(" select COUNT(*) from student where 1=1 and state!=4 ");
        List list = new ArrayList<>();
        if (stuName!=null && stuName!="") {
            sql.append(" AND stuname LIKE ? ");
            list.add("%" + stuName + "%");
        }
        if (stuNo!=null && stuNo!="") {
            sql.append(" AND stuno=? ");
            list.add(stuNo);
        }
        if(sex != -1){
            sql.append(" AND sex=? ");
            list.add(Integer.toString(sex));
        }
        ResultSet resultSet = query(sql.toString(), list);
        int total = 0;
        if (resultSet != null) {
            try {
                while(resultSet.next()){
                    total = resultSet.getInt(1);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
        }
        return total;
    }

    @Override
    public List<Student> getStudentMessage(String stuName, String stuNo, int sex, int pageIndex, int pageSize) {
        StringBuilder sql = new StringBuilder(" select * from student where 1=1 and state!=4 ");
        List list = new ArrayList<>();
        if (stuName!=null && stuName!="") {
            sql.append(" AND stuname LIKE ? ");
            list.add("%" + stuName + "%");
        }
        if (stuNo!=null && stuNo!="") {
            sql.append(" AND stuno=? ");
            list.add(stuNo);
        }
        if(sex != -1){
            sql.append(" AND sex=? ");
            list.add(Integer.toString(sex));
        }
        sql.append(" LIMIT ?,? ");
        list.add((pageIndex-1)*pageSize);
        list.add(pageSize);
        ResultSet resultSet = query(sql.toString(), list);
        List<Student> stuList = new ArrayList<>();
        if(resultSet != null){
            try {
                while(resultSet.next()){
                    Student student = new Student();
                    student.setStuName(resultSet.getString("stuname"));
                    student.setAddress(resultSet.getString("address"));
                    student.setEmail(resultSet.getString("email"));
                    student.setGid(resultSet.getInt("gid"));
                    student.setIntroduction(resultSet.getString("introduction"));
                    student.setPhone(resultSet.getString("phone"));
                    student.setIdNumber(resultSet.getString("idnumber"));
                    student.setStuId(resultSet.getInt("stuid"));
                    student.setPolitics(resultSet.getString("politics"));
                    student.setProfession(resultSet.getString("profession"));
                    student.setRegDate(resultSet.getDate("regdate"));
                    student.setRegistered(resultSet.getString("registered"));
                    student.setSex(resultSet.getInt("sex"));
                    student.setState(resultSet.getInt("state"));
                    student.setStuNo(resultSet.getString("stuno"));
                    stuList.add(student);
                }
                return stuList;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
        }

        return null;
    }

    @Override
    public Student getStudentByStuId(Integer stuId) {
        String sql = "select * from student where stuid=? ";
        List<String> list = new ArrayList<>();
        list.add(stuId.toString());
        ResultSet resultSet = query(sql, list);
        if(resultSet != null){
            Student student = null;
            try {
                while(resultSet.next()){
                    student = new Student();
                    student.setStuName(resultSet.getString("stuname"));
                    student.setAddress(resultSet.getString("address"));
                    student.setEmail(resultSet.getString("email"));
                    student.setGid(resultSet.getInt("gid"));
                    student.setIntroduction(resultSet.getString("introduction"));
                    student.setPhone(resultSet.getString("phone"));
                    student.setIdNumber(resultSet.getString("idnumber"));
                    student.setStuId(resultSet.getInt("stuid"));
                    student.setPolitics(resultSet.getString("politics"));
                    student.setProfession(resultSet.getString("profession"));
                    student.setRegDate(resultSet.getDate("regdate"));
                    student.setRegistered(resultSet.getString("registered"));
                    student.setSex(resultSet.getInt("sex"));
                    student.setState(resultSet.getInt("state"));
                    student.setStuNo(resultSet.getString("stuno"));
                }
                return student;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
        }

        return null;
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "update student set stuNo=?,stuName=?,gid=?,sex=?,email=?,phone=?," +
                "registered=?,address=?,politics=?,idnumber=?,profession=?,introduction=? where stuid=?";
        List list = new ArrayList<>();
        list.add(student.getStuNo());
        list.add(student.getStuName());
        list.add(student.getGid().toString());
        list.add(student.getSex().toString());
        list.add(student.getEmail());
        list.add(student.getPhone());
        list.add(student.getRegistered());
        list.add(student.getAddress());
        list.add(student.getPolitics());
        list.add(student.getIdNumber());
        list.add(student.getProfession());
        list.add(student.getIntroduction());
        list.add(student.getStuId());
        int update = update(sql, list);
        return update;
    }

    @Override
    public int deleteStuByStuId(String stuId) {
        String sql = "delete from student where stuid=?";
        List<String> list = new ArrayList<>();
        list.add(stuId);
        int update = update(sql, list);
        return update;
    }

    @Override
    public int addStudent(Student student) {
        String sql = "INSERT INTO student(stuNo,stuName,gid,sex,email,phone," +
                "registered,address,politics,idNumber,profession,introduction,regdate,state) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
        List<String> list = new ArrayList<>();
        list.add(student.getStuNo());
        list.add(student.getStuName());
        list.add(student.getGid().toString());
        list.add(student.getSex().toString());
        list.add(student.getEmail());
        list.add(student.getPhone());
        list.add(student.getRegistered());
        list.add(student.getAddress());
        list.add(student.getPolitics());
        list.add(student.getIdNumber());
        list.add(student.getProfession());
        list.add(student.getIntroduction());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list.add(simpleDateFormat.format(student.getRegDate()));
        int update = update(sql, list);
        return update;
    }

    @Override
    public Student checkStuByStuNo(String stuNo) {
        Student student = null;
        try {
            String sql = "select * from student where stuno=?";
            List list = new ArrayList();
            list.add(stuNo);
            ResultSet resultSet = query(sql, list);
            if(resultSet != null){
                while(resultSet.next()){
                    student = new Student();
                    student.setStuNo(resultSet.getString("stuno"));
                    return student;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

    @Override
    public Student checkStuByEmail(String email) {
        Student student = null;
        try {
            String sql = "select * from student where email=?";
            List list = new ArrayList();
            list.add(email);
            ResultSet resultSet = query(sql, list);
            if(resultSet != null){
                while(resultSet.next()){
                    student = new Student();
                    student.setEmail(resultSet.getString("email"));
                    return student;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

    @Override
    public Student checkStuByPhone(String phone) {
        Student student = null;
        try {
            String sql = "select * from student where phone=?";
            List list = new ArrayList();
            list.add(phone);
            ResultSet resultSet = query(sql, list);
            if(resultSet != null){
                while(resultSet.next()){
                    student = new Student();
                    student.setPhone(resultSet.getString("phone"));
                    return student;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

    @Override
    public Student checkStuByIdNumber(String idNumber) {
        Student student = null;
        try {
            String sql = "select * from student where idnumber=?";
            List list = new ArrayList();
            list.add(idNumber);
            ResultSet resultSet = query(sql, list);
            if(resultSet != null){
                while(resultSet.next()){
                    student = new Student();
                    student.setIdNumber(resultSet.getString("idnumber"));
                    return student;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }

        return null;
    }

}
