package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
import com.example.shanwuwu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configurable
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public User login(@RequestBody User user){
        //密码先加密，然后跟数据库的比较
       user.setUserPassword(MD5Utils.inputPassToFormPass(user.getUserPassword()));
       User loing = userMapper.login(user);
       if(loing !=null){
           loing.setUserPassword("开外挂");
           return loing;
       }
        return new User();
    }




}
