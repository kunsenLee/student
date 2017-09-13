package com.lee.student.util;

import com.lee.student.model.Result;
import com.sun.org.apache.regexp.internal.RE;

/**
 * @Author: lee
 * @Date: Create in 2017-9-5 10:59
 */
public class ResultUtil {

    public static Result success(Object object){

        Result result = new Result();

        result.setCode(0);
        result.setMsg("操作成功");
        result.setData(object);

        return result;
    }

    public static Result success(){
       return success(null);

    }

    public static Result error(Integer code,String msg){
        Result result = new Result();

        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
