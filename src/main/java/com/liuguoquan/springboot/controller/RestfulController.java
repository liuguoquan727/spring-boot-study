package com.liuguoquan.springboot.controller;

import com.liuguoquan.springboot.bean.Response;
import com.liuguoquan.springboot.bean.Student;
import com.liuguoquan.springboot.mapper.StudentMapper;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Descriptions: GET、POST 请求示例
 *
 * Created by liuguoquan on 2017/10/31.
 */

@RestController
@RequestMapping("api/rest")
public class RestfulController {

  private final Logger mLogger = LogManager.getLogger(RestfulController.class);

  @Autowired StudentMapper mMapper;

  /**
   * GET 不带参数
   */
  @RequestMapping(method = RequestMethod.GET)
  public Response<List<Student>> testGet(HttpServletRequest request) {
    mLogger.info(request.getQueryString());
    mLogger.info(request.getHeader("userId"));
    Response<List<Student>> response = new Response<>();
    response.data = mMapper.getStudents();
    response.code = 200;
    return response;
  }

  /**
   * GET带参数
   */
  @RequestMapping(method = RequestMethod.GET, path = "/stu")
  public Response tesGetParam(HttpServletRequest request,
      @RequestParam(name = "userId") String id) {
    Student student = mMapper.queryById(id);
    Response<Student> response = new Response<>();
    if (student != null) {
      response.code = 200;
      response.data = student;
    } else {
      response.code = -1;
    }
    return response;
  }

  /**
   * POST 表单传参
   */
  @RequestMapping(method = RequestMethod.POST, path = "/post")
  public Response testPost(HttpServletRequest request, @RequestParam(name = "userId") String id) {
    Student student = mMapper.queryById(id);
    Response<Student> response = new Response<>();
    if (student != null) {
      response.code = 200;
      response.data = student;
    } else {
      response.code = -1;
    }
    return response;
  }

  /**
   * POST Body传参
   */
  @RequestMapping(method = RequestMethod.POST, path = "/insert")
  public Response testPostBody(HttpServletRequest request, @RequestBody Student student) {
    Response response = new Response();
    try {
      mMapper.insert(student);
      response.code = 200;
      response.data = mMapper.getStudents();
    } catch (Exception e) {
      response.msg = e.getMessage();
      response.code = -1;
      return response;
    }
    return response;
  }
}
