package com.liuguoquan.springboot.bean;

import java.io.Serializable;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/26.
 */

public class Student implements Serializable {

  private static final long serialVersionUID = 6816204218437248771L;

  private int id;
  private String name;
  private int age;
  private String sex;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
