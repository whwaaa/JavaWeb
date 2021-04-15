package com.xiaojumao.service.imp;

import com.xiaojumao.bean.Users;
import com.xiaojumao.dao.imp.UsersDaoImp;
import com.xiaojumao.service.UsersService;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public class UsersServiceImp implements UsersService {
    UsersDaoImp daoImp = new UsersDaoImp();
    @Override
    public Users loginVerfi(String username, String password) {
        return daoImp.loginVerfi(username, password);
    }
}
