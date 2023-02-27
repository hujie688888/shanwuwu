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

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public UserVip queryVip(String userId){
        UserVip userVip = new UserVip();
        if (userId == null) {
            userVip = userVipService.queryVip(userId);
        }

        return userVip;
    }

    @RequestMapping(value = "/open",method = RequestMethod.POST)
    public String openVip(@RequestBody UserVip userVip) {
        if(userVip.getUserId() == null){
            return "请先登录";
        }
        if(userVip.getSetMeal()<0){
            return "请选择套餐类型";
        }
        if (userVip != null) {
            userVipService.openVip(userVip);
        }
        return "开通成功";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateVip(@RequestBody UserVip userVip ) {

        return "修改失败";
    }
}

