package com.liuguoquan.springboot;

import com.liuguoquan.springboot.bean.ConfigBean;
import com.liuguoquan.springboot.bean.ConfigTestBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, ConfigTestBean.class})
public class PropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PropertiesApplication.class, args);
	}
}
