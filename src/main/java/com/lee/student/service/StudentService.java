package com.lee.student.service;

import com.lee.student.enums.ResultEnum;
import com.lee.student.exception.StudentException;
import com.lee.student.model.Student;
import com.lee.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lee
 * @Description:
 * @Date: Create in 2017-9-4 16:24
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void getAge(Integer id) throws Exception {
        Student student = studentRepository.findOne(id);
        Integer age = student.getAge();
        System.out.println(age);
        if (age < 6){
            //返回"未到入学年龄" code=100
            throw new StudentException(ResultEnum.ERROR_MIN);

        }else if (age > 12){
            //返回"超出入学年龄" code=101
            throw new StudentException(ResultEnum.ERROR_MAX);
        }
    }

    /**
     * 通过id查询一个学生信息
     * @param id
     * @return
     */
    public Student findOne(Integer id){
        return studentRepository.findOne(id);
    }
}
