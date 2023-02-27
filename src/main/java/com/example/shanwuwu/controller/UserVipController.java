package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.User;
import com.example.shanwuwu.entity.UserVip;
import com.example.shanwuwu.mapper.UserMapper;
import com.example.shanwuwu.service.UserVipService;
import com.example.shanwuwu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configurable
@RestController
@CrossOrigin
@RequestMapping("/vip")
public class UserVipController {

    @Autowired
    UserVipService userVipService;

    @RequestMapping(value = "/queryVip",method = RequestMethod.POST)
    public UserVip queryVip(String userId){
        UserVip userVip = new UserVip();
        if (userId == null) {
            userVip = userVipService.queryVip(userId);
        }

        return userVip;
    }

    @RequestMapping(value = "/openVip",method = RequestMethod.POST)
    public String openVip( UserVip userVip) {
        if (userVip == null) {
            userVipService.openVip(userVip);
        }
        return "开通成功";
    }

    @RequestMapping(value = "/updateVip",method = RequestMethod.POST)
    public String updateVip( UserVip userVip ) {

        return "修改失败";
    }
}

