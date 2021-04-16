package com.xiaojumao.utils;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-16 14:05
 * @Modified By:
 */
public enum SexEnum {
    // 0 女  1 男  -1 未指定
    MALE(1,"男"),
    FEMALE(0,"女"),
    NOTSPECIFIED(-1,"未指定");

    public final Integer type;
    public final String value;
    SexEnum(Integer type, String value){
        this.type = type;
        this.value = value;
    }
}
