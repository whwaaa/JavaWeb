package com.xiaojumao.bean;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-14 8:49
 * @Modified By:
 */
public class Users {
    private Integer userId;
    private String password;
    private String realName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Users(){}

    public Users(String Integer, String password, String realName) {
        this.userId = userId;
        this.password = password;
        this.realName = realName;
    }
}
