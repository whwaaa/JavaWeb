package com.xiaojumao.dao.imp;

import com.xiaojumao.bean.Users;
import com.xiaojumao.dao.DBUtils;
import com.xiaojumao.dao.UsersDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public class UsersDaoImp extends DBUtils implements UsersDao {
    @Override
    public Users loginVerfi(String username, String password) {
        ArrayList<String> list = new ArrayList<>();
        list.add(username);
        list.add(password);
        String sql = "select * from users where loginname=? and password=?";
        ResultSet resultSet = query(sql, list);
        Users users = null;
        if (resultSet != null) {
            try {
                while(resultSet.next()){
                    users = new Users();
                    users.setPassword(resultSet.getString("password"));
                    users.setUserId(resultSet.getInt("userid"));
                    users.setRealName(resultSet.getString("realname"));
                }
                return users;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                closeAll();
            }
        }
        return null;
    }
}
