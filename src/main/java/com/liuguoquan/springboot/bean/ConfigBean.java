package com.liuguoquan.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/24.
 */

@ConfigurationProperties
public class ConfigBean {
  private String username;
  private String slogan;
  private String secret;
  private String uuid;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSlogan() {
    return slogan;
  }

  public void setSlogan(String slogan) {
    this.slogan = slogan;
  }

  public String getSecret() {
    return secret;
  }

  public void setSecret(String secret) {
    this.secret = secret;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
