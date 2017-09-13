package com.lee.student.enums;

/**
 * 自定义异常错误码枚举类
 * @Author: lee
 * @Date: Create in 2017-9-5 15:00
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"操作成功"),
    ERROR_MIN(100,"年龄太小,未到入学年龄"),
    ERROR_MAX(101,"年龄太大,超过入学年龄"),
    ;
    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
