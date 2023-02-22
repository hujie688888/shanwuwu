package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("login")//页面的url地址
    public String getLogin(Model model)//对应函数
    {
        List<User> list = userMapper.findAll();
        model.addAttribute("user",list);
        model.addAttribute("name","bigsai");
        return "login";//与templates中index.html对应
    }
}
