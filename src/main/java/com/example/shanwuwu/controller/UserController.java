package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
import com.example.shanwuwu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.*;


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

        List<User> restUser= userMapper.findUser(user.getPhoneNumber());
        if(restUser.isEmpty()){
            return "验证失败，请输入账号";
        }
        //根据账号查询数据库，验证账号正确性
        return "验证成功";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register( User user) {
        if (user == null) {
            return "验证失败";
        }
        if(user.getPhoneNumber() == null){
            return "请输入手机号";
        }
        if(user.getUserEmail() == null){
            return "请输入邮箱";
        }
        if(user.getUserPassword() ==  null){
            return "请输入密码";
        }
        //String passwrod = MD5Utils.inputPassToFormPass(user.getUserPassword());
        //user.setUserPassword(passwrod);
        user.setUserPassword(MD5Utils.inputPassToFormPass(user.getUserPassword()));
        int restUser= userMapper.register(user);
        if(restUser <0){
            return "注册失败，请重试";
        }
        //根据账号查询数据库，验证账号正确性
        return "注册成功";
    }

    @RequestMapping(value = "/password",method = RequestMethod.POST)
    public String updateUser( User user) {
        if (user == null) {
            return "验证失败";
        }
        if(user.getPhoneNumber() == null){
            return "请输入手机号";
        }
        if(user.getUserPassword() ==  null){
            return "请输入密码";
        }
        if(user.getId() !=null){

        }
        int password= userMapper.updateUser(user);
        if(password>0){
            return "修改成功";
        }
        //根据账号查询数据库，验证账号正确性
        return "修改失败";
    }
}

