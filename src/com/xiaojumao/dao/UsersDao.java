package com.xiaojumao.dao;

import com.xiaojumao.bean.Users;


/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface UsersDao {
    /**
     * 验证数据库账号密码是否正确
     */
    public Users loginVerfi(String username, String password);
}
