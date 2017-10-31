package com.liuguoquan.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Descriptions: 自定义配置文件绑定
 *
 * Created by liuguoquan on 2017/10/24.
 */

@Configuration
@ConfigurationProperties
@PropertySource("classpath:test.properties")
public class ConfigTestBean {
  private String name;
  private String slogan;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }
}
