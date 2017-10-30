package com.liuguoquan.springboot;

import com.liuguoquan.springboot.bean.ConfigBean;
import com.liuguoquan.springboot.bean.ConfigTestBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@MapperScan("com.liuguoquan.springboot.mapper")
@EnableConfigurationProperties({ConfigBean.class, ConfigTestBean.class})
public class SpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }
}
