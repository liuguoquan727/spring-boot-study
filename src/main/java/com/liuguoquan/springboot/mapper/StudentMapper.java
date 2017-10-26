package com.liuguoquan.springboot.mapper;

import com.liuguoquan.springboot.bean.Student;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Descriptions: https://mp.weixin.qq.com/s/1ikYOxF9XxuuuhNjWvtDsw https://github.com/ityouknow/spring-boot-examples/blob/master/spring-boot-mybatis-annotation
 * Created by liuguoquan on 2017/10/26.
 */

public interface StudentMapper {

  @Select("SELECT * FROM STUDENT")
  List<Student> getStudents();

  @Insert("insert into student(name,age,sex) values(#{name},#{age},#{sex})")
  void insert(Student stu);
}
