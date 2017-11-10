package com.liuguoquan.springboot.bean;

import java.io.Serializable;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/10/31.
 */

public class Response<T> implements Serializable {
  public int code;
  public String msg;
  public T data;
  public long responseTime = System.currentTimeMillis();
}
