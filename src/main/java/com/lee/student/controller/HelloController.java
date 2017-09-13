package com.lee.student.controller;

import com.lee.student.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lee
 * @Description:
 * @Date: Create in 2017-9-4 9:04
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @GetMapping(value = "/say/{name}")
    public String say(@PathVariable("name") String name){

        return studentProperties.getGrade() + "  " +name;
        //return "Hello Spring Boot!";

    }
}
