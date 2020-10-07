package com.wechat.analyse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 热部署  1.项目立项2.项目计划 3.前端的登陆注册
 */
@Controller
public class ConfigController {

    @RequestMapping("/boot/hello")
    @ResponseBody
    public String hello(){
        return "spring boot hello";
    }

}
