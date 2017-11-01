package com.liuguoquan.springboot.mapper;

import com.liuguoquan.springboot.bean.Student;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * Descriptions: https://mp.weixin.qq.com/s/1ikYOxF9XxuuuhNjWvtDsw https://github.com/ityouknow/spring-boot-examples/blob/master/spring-boot-mybatis-annotation
 * Created by liuguoquan on 2017/10/26.
 */

@Mapper
@Component
public interface StudentMapper {

  @Select("SELECT * FROM STUDENT")
  List<Student> getStudents();

  @Select("select * from student where id=#{id}")
  Student queryById(@Param("id") String id);

  @Insert("insert into student(name,age,sex,address) values(#{name},#{age},#{sex},#{address})")
  void insert(Student stu);

  @Update("update student set name=#{name},age=#{age},sex=#{sex},address=#{address} where id=#{id}")
  void update(Student stu);

  @Delete("delete from student where id=#{id}")
  void delete(@Param("id") String id);

  @DeleteProvider(type = SqlBuilder.class, method = "deleteByids")
  void deleteByIds(@Param("ids") String[] ids);

  class SqlBuilder {
    //删除的方法
    public String deleteByids(@Param("ids") final String[] ids) {
      StringBuffer sql = new StringBuffer();
      sql.append("DELETE FROM STUDENT WHERE id in(");
      for (int i = 0; i < ids.length; i++) {
        if (i == ids.length - 1) {
          sql.append(ids[i]);
        } else {
          sql.append(ids[i]).append(",");
        }
      }
      sql.append(")");
      return sql.toString();
    }
  }
}
