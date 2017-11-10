package com.liuguoquan.springboot.mapper;

import com.liuguoquan.springboot.bean.Student;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Descriptions: https://mp.weixin.qq.com/s/1ikYOxF9XxuuuhNjWvtDsw
 *
 * https://github.com/ityouknow/spring-boot-examples/blob/master/spring-boot-mybatis-annotation
 * Created by liuguoquan on 2017/10/26.
 */

@Component
@Mapper
public interface StudentXMLMapper {

  List<Student> getStudents();

  Student queryById(String id);

  void insert(Student stu);

  void update(Student stu);

  void delete(String id);

  void deleteByIds(String[] ids);
}
