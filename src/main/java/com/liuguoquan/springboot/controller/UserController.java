package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.ConfigBean;
import com.liuguoquan.springboot.bean.Student;
import com.liuguoquan.springboot.mapper.StudentMapper;
import com.liuguoquan.springboot.service.StudentService;
import java.util.List;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/24.
 */

@RestController
public class UserController {

  @Value("${username}")
  private String name;
  @Value("${slogan}")
  private String slogan;

  @Autowired ConfigBean configBean;
  @Autowired StudentService mStudentService;
  @Autowired StudentMapper mStudentMapper;

  @RequestMapping("/")
  public String index() {
    return name + slogan;
  }

  @RequestMapping("/config")
  public String getConfig() {
    return configBean.getUsername()
        + " : "
        + configBean.getSlogan()
        + ":"
        + configBean.getSecret()
        + ":"
        + configBean.getUuid();
  }

  @RequestMapping("/list")
  public List<Student> getList() {
    return mStudentService.getStudents();
  }

  @RequestMapping("/get")
  public List<Student> getStudents() {
    return mStudentMapper.getStudents();
  }

  @RequestMapping("/insert")
  public void insert() {
    Student student = new Student();
    student.setName("xu");
    student.setAge(23);
    student.setSex("female");
    mStudentMapper.insert(student);
  }
}
