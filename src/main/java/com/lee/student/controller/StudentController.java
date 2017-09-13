package com.lee.student.controller;

import com.lee.student.model.Result;
import com.lee.student.model.Student;
import com.lee.student.repository.StudentRepository;
import com.lee.student.service.StudentService;
import com.lee.student.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lee
 * @Description:
 * @Date: Create in 2017-9-4 15:13
 */
@RestController
@RequestMapping(value = "/stu")
public class
StudentController {

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;

    /**
     * 查询学生列表
     * @return
     */
    @GetMapping(value = "/list")
    public List<Student> studentList(){
        return studentRepository.findAll();
    }

    /**
     * 添加一个学生
     * @return
     */
    @PostMapping(value = "/add")
    public Result<Student> stuAdd(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            String errorMsg = bindingResult.getFieldError().getDefaultMessage();

            Result result = ResultUtil.error(1,errorMsg);

            return result;
        }

        student.setName(student.getName());
        student.setAge(student.getAge());
        student.setGrade(student.getGrade());

        return ResultUtil.success(studentRepository.save(student));
    }

    @GetMapping(value = "/query/{id}")
    public Student queryById(@PathVariable("id") Integer id){
        return studentRepository.findOne(id);
    }

    /**
     * 更新一个学生
     * @param id
     * @param name
     * @param age
     * @param grade
     * @return
     */
    @PutMapping(value = "/update/{id}")
    public Student stuUpdate(@PathVariable("id") Integer id,
                          @RequestParam("name") String name,
                          @RequestParam("age") Integer age,
                          @RequestParam("grade") String grade){

        Student student = new Student();

        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setGrade(grade);

        return studentRepository.save(student);

    }

    /**
     * 删除一个学生
     * @param id
     */
    @DeleteMapping(value = "/delete/{id}")
    public void stuDelete(@PathVariable("id") Integer id){
        studentRepository.delete(id);
    }

    /**
     * 通过年龄查询学生列表
     * @param age
     * @return
     */
    @GetMapping(value = "/list/age/{age}")
    public List<Student> listByAge(@PathVariable("age") Integer age){
        return studentRepository.findByAge(age);
    }

    /**
     * 查询年龄是否符合要求
     * @param id
     * @throws Exception
     */
    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        studentService.getAge(id);

    }




}
