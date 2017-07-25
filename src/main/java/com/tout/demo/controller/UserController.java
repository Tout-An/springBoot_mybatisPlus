package com.tout.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.tout.demo.entity.User;
import com.tout.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Tout-An
 * @since 2017-07-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private IUserService userService;

  /**
   * 分页 PAGE
   */
  @GetMapping("/list") //等同于@RequestMapping(value = "/list",method = RequestMethod.GET)
  public Page<User> list() {
    return userService.selectPage(new Page<>(0, 12));
  }


  /**
   * 添加
   */
  @PostMapping("/add")
  public Object add() {
    User user = new User(1, "张三", 17, "12345678");
    JSONObject result = new JSONObject();
    result.put("result", userService.insert(user));
    return result;
  }

  /**
   * 删除
   */
  @PostMapping("/del")
  public Object del() {
    JSONObject result = new JSONObject();
    result.put("result", userService.deleteById(1));
    return result;
  }

  /**
   * 更新
   */
  @PostMapping("/upd")
  public Object upd() {
    User user = new User(1, "张三1", 17, "12345678");
    JSONObject result = new JSONObject();
    result.put("result", userService.insertOrUpdate(user));
    return result;
  }

  /**
   * 查询
   */
  @GetMapping("/query")
  public Object query() {
    JSONObject result = new JSONObject();
    result.put("result", userService.selectById(1));
    return result;
  }


  /**
   * 添加
   */
  @PostMapping("/addBatch")
  public Object addBatch() {
    List<User> list = new ArrayList<>();
    User user = new User(2, "李四", 17, "12345678");
    list.add(user);
    user = new User(3, "王五", 17, "12345678");
    list.add(user);
    JSONObject result = new JSONObject();
    result.put("result", userService.insertBatch(list));
    return result;
  }

}
