package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.Student;
import com.liuguoquan.springboot.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/24.
 */

@RequestMapping("api/jdbc")
@RestController
public class JdbcTemplateController {

  @Autowired StudentService mStudentService;

  @RequestMapping("/get")
  public List<Student> getList() {
    return mStudentService.getStudents();
  }

  @RequestMapping("/insert")
  public void insert() {
    Student student = new Student();
    student.setName("zhou");
    student.setAge("25");
    student.setSex("female");
    mStudentService.insert(student);
  }
}
