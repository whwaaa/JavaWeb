package com.xiaojumao.dao.imp;

import com.xiaojumao.bean.Grade;
import com.xiaojumao.dao.DBUtils;
import com.xiaojumao.dao.GradeDao;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:55
 * @Modified By:
 */
public class GradeDaoImp extends DBUtils implements GradeDao {
    @Override
    public List<Grade> getGrade() {
        List<Grade> list = new ArrayList<>();
        try {
            String sql = "select * from grade";
            ResultSet resultSet = query(sql, null);
            if(resultSet != null){
                while(resultSet.next()){
                    Grade grade = new Grade();
                    grade.setGradeId(resultSet.getInt("gradeid"));
                    grade.setGradeName(resultSet.getString("gradename"));
                    list.add(grade);
                }
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return null;
    }
}
