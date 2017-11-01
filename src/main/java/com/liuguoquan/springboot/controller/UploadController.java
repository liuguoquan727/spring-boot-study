package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.Response;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Descriptions:
 *
 * Created by liuguoquan on 2017/11/1.
 */

@RestController
@RequestMapping("api/upload")
public class UploadController {

  /**
   * 单个文件上传
   */
  @RequestMapping(method = RequestMethod.POST)
  public Response upload(@RequestParam("file") MultipartFile file) {
    Response response = new Response();
    if (!file.isEmpty()) {
      try {
        BufferedOutputStream out = new BufferedOutputStream(
            new FileOutputStream(new File("123.jpeg")));
        out.write(file.getBytes());
        out.flush();
        out.close();
      } catch (IOException e) {
        response.msg = e.getMessage();
        response.code = -1;
        return response;
      }
    } else {
      response.msg = "文件为空";
      response.code = -1;
      return response;
    }
    response.code = 200;
    return response;
  }

  /**
   * 多文件上传
   */
  @RequestMapping(path = "/batch", method = RequestMethod.POST)
  public Response uploadBatch(HttpServletRequest request) {
    Response response = new Response();
    List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("file");
    BufferedOutputStream out = null;
    for (MultipartFile file : multipartFiles) {
      if (!file.isEmpty()) {
        try {
          out = new BufferedOutputStream(
              new FileOutputStream(new File(System.currentTimeMillis() + ".jpeg")));
          out.write(file.getBytes());
          out.flush();
          out.close();
        } catch (IOException e) {
          response.msg = e.getMessage();
          response.code = -1;
          return response;
        }
      } else {
        response.msg = "文件为空";
        response.code = -1;
        return response;
      }
    }
    response.code = 200;
    response.msg = "上传成功";
    return response;
  }
}
