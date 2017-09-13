package com.lee.student.repository;

import com.lee.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: lee
 * @Description:
 * @Date: Create in 2017-9-4 15:18
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByAge(Integer age);
}
