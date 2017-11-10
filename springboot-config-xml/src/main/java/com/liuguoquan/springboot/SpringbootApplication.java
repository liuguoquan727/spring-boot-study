package com.liuguoquan.springboot;

import com.liuguoquan.springboot.bean.ConfigBean;
import com.liuguoquan.springboot.bean.ConfigTestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 配置文件解析
 */

@EnableConfigurationProperties({ConfigBean.class, ConfigTestBean.class})
@SpringBootApplication
public class SpringbootApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootApplication.class, args);
  }
}
