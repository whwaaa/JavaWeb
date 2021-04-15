package com.xiaojumao.service;

import com.xiaojumao.bean.Users;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:52
 * @Modified By:
 */
public interface UsersService {

    /**
     * 查询数据库用户信息
     */
    public Users loginVerfi(String username, String password);

}
