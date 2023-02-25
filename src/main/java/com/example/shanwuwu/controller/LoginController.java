package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.mapper.UserMapper;
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
    public User login(User user){
       User loing = userMapper.login(user);
       if(loing !=null){
           return loing;
       }
        return new User();
    }




}
