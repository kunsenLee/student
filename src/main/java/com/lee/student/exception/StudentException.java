package com.lee.student.exception;

import com.lee.student.enums.ResultEnum;

/**
 * 自定义异常类
 * @Author: lee
 * @Date: Create in 2017-9-5 14:37
 */
public class StudentException extends RuntimeException{

    private Integer code;

    public StudentException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
