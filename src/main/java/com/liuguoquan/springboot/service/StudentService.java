package com.liuguoquan.springboot.service;

import com.liuguoquan.springboot.bean.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

/**
 * Descriptions: http://blog.csdn.net/catoop/article/details/50507516
 *
 * Created by liuguoquan on 2017/10/26.
 */

@Service
public class StudentService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Student> getStudents() {
    String sql = "SELECT ID,NAME,AGE,SEX FROM STUDENT";
    return jdbcTemplate.query(sql, new RowMapper<Student>() {
      @Override public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getString("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getString("age"));
        student.setSex(resultSet.getString("sex"));
        student.setAddress(resultSet.getString("address"));
        return student;
      }
    });
  }

  public void insert(Student student) {
    jdbcTemplate.update("insert into student(name,age,sex,address) values(?,?,?,?)",
        student.getName(),
        student.getAge(), student.getSex(), student.getAddress());
  }
}
