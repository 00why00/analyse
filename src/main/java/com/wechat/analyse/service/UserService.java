package com.wechat.analyse.service;

import com.wechat.analyse.bean.Result;
import com.wechat.analyse.bean.User;
import com.wechat.analyse.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user 用户
     * @return 结果
     */
    public Result register(User user){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        User existUser=userMapper.findUserByName(user.getUsername());
        if(existUser!=null){
            result.setMsg("用户名已存在");
        }else {
            userMapper.register(user);
            result.setMsg("注册成功");
            result.setSuccess(true);
            result.setDetail(user);
        }
        return result;
    }

    /**
     * 登录
     * @param user 用户
     * @return 结果
     */
    public Result login(User user){
        Result result=new Result();
        result.setSuccess(false);
        result.setDetail(null);
        Long userId=userMapper.login(user);
        if(userId==null){
            result.setMsg("用户名或密码错误");
        }else {
            result.setMsg("登录成功");
            result.setSuccess(true);
            result.setDetail(user);
        }
        return result;
    }
}
