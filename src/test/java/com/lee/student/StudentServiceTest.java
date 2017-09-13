package com.lee.student;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.lee.student.model.Student;
import com.lee.student.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: lee
 * @Date: Create in 2017-9-5 15:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;


    @Test
    public void findOneTest(){

        Integer id = 12;

        Student student = studentService.findOne(id);

        Assert.assertEquals(new Integer(7),student.getAge());

    }

}
