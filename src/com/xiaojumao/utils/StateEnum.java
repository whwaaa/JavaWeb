package com.xiaojumao.utils;

/**
 * @Author: whw
 * @Description:
 * @Date Created in 2021-04-16 13:59
 * @Modified By:
 */
public enum StateEnum {
    //  1 在读  2 休学  3 退学  4 删除
    READING(1,"再读"),
    SUSPENSION(2,"休学"),
    DROPOUT(3,"退学"),
    DELETE(4,"删除");

    public final Integer type;
    public final String value;

    StateEnum(Integer type, String value){
        this.type = type;
        this.value = value;
    }

}
