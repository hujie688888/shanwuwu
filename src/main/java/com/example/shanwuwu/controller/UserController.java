package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.ListUtils;

import java.util.List;

@Configurable
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/select",method = RequestMethod.POST)
    public Object selectUser(){
        List<User> list = userMapper.findAll();
        return list;
    }

    @RequestMapping(value = "/check",method = RequestMethod.POST)
    public String verificationAccount(@RequestBody User user) {
        if (user == null) {
            return "验证失败，请输入账号";
        }

        List<User> restUser= userMapper.findUser(user.getUserName());
        if(restUser.isEmpty()){
            return "验证失败，请输入账号";
        }
        //根据账号查询数据库，验证账号正确性
        return "验证成功";
    }
}

