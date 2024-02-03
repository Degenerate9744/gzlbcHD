package com.example.mynhdemo.controller;

import com.example.mynhdemo.entity.domain.User;
import com.example.mynhdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName：UserController
 * @Author：Acmsdy
 * @Date：2023-12-21 21:39
 * @Describe：
 */
@Controller
@RequestMapping("User")
public class UserController {
    @Autowired
    private UserService userService;

    /*添加用户*/
    @ResponseBody
    @RequestMapping("insert")
    public boolean insert(User user){
        return userService.insert(user) == 1;
    }
    /*删除用户*/
    @ResponseBody
    @RequestMapping("delete")
    public boolean delete(Integer id){
        return userService.deleteByPrimaryKey(id) == 1;
    }
}
