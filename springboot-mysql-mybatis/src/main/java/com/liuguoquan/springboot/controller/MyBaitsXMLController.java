package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.Student;
import com.liuguoquan.springboot.mapper.StudentXMLMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descriptions: xml 配置方法使用 MyBaits
 *
 * Created by liuguoquan on 2017/10/30.
 */

@RequestMapping("api/mybaits/xml")
@RestController
public class MyBaitsXMLController {
  @Autowired StudentXMLMapper mStudentMapper;

  @RequestMapping("/get")
  public List<Student> getStudents() {
    return mStudentMapper.getStudents();
  }

  @RequestMapping("/insert")
  public void insert() {
    Student student = new Student();
    student.setName("wang");
    student.setAge("25");
    student.setSex("female");
    mStudentMapper.insert(student);
  }

  @RequestMapping("/id")
  public Student queryById() {
    Student stu = mStudentMapper.queryById("1");
    return stu;
  }

  @RequestMapping("/update")
  public void update() {
    Student stu = mStudentMapper.queryById("1");
    stu.setAge("30");
    mStudentMapper.update(stu);
  }

  @RequestMapping("/delete")
  public void delete() {
    mStudentMapper.delete("2");
  }

  @RequestMapping("/deleteIds")
  public void deleteIds() {
    mStudentMapper.deleteByIds(new String[] {"4", "5"});
  }
}
