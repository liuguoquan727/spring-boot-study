package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.ConfigBean;
import com.liuguoquan.springboot.bean.ConfigTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/30.
 */

@RestController
@RequestMapping("api/config")
public class ConfigController {
  @Value("${username}")
  private String name;
  @Value("${slogan}")
  private String slogan;

  @Autowired ConfigBean configBean;
  @Autowired ConfigTestBean configTestBean;

  @RequestMapping("/")
  public String index() {
    return name + slogan;
  }

  @RequestMapping("/test")
  public String testConfig() {
    return configTestBean.getName() + configTestBean.getSlogan();
  }

  @RequestMapping("/config")
  public String getConfig() {
    return configBean.getUsername()
        + " : "
        + configBean.getSlogan()
        + ":"
        + configBean.getSecret()
        + ":"
        + configBean.getUuid();
  }
}
