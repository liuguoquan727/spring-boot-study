package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.Student;
import com.liuguoquan.springboot.mapper.StudentMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descriptions: 注解方式使用MyBaits
 *
 * Created by liuguoquan on 2017/10/30.
 */

@RequestMapping("api/mybaits")
@RestController
public class MyBaitsController {
  @Autowired StudentMapper mStudentMapper;

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
