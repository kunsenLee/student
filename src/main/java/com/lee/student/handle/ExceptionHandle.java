package com.lee.student.handle;

import com.lee.student.exception.StudentException;
import com.lee.student.model.Result;
import com.lee.student.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常
 * @Author: lee
 * @Date: Create in 2017-9-5 13:41
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof StudentException){
            StudentException studentException = (StudentException) e;
            return ResultUtil.error(studentException.getCode(),studentException.getMessage());
        }else{
            logger.error("[系统异常] {}",e);
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
