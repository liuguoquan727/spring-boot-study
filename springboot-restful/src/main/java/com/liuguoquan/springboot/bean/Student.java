package com.liuguoquan.springboot.bean;

import java.io.Serializable;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/26.
 */

public class Student implements Serializable {

  private static final long serialVersionUID = 6816204218437248771L;
  private String id;
  private String name;
  private String age;
  private String sex;
  private String address;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
