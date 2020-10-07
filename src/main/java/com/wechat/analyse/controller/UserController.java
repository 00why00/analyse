package com.wechat.analyse.controller;

import com.wechat.analyse.bean.Result;
import com.wechat.analyse.bean.User;
import com.wechat.analyse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/register")
    public Result register(User user){
       return  userService.register(user);
    }
    @RequestMapping(value = "/login")
    public Result login(User user){
        return userService.login(user);
    }
}
