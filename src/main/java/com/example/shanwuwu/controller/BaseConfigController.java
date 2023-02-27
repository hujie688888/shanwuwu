package com.example.shanwuwu.controller;

import com.example.shanwuwu.entity.BaseConfig;
import com.example.shanwuwu.entity.UserVip;
import com.example.shanwuwu.service.BaseConfigService;
import com.example.shanwuwu.service.UserVipService;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Configurable
@RestController
@CrossOrigin
@RequestMapping("/config")
public class BaseConfigController {

    @Autowired
    BaseConfigService baseConfigService;

    @RequestMapping(value = "/query",method = RequestMethod.POST)
    public List<BaseConfig> queryConfig(){
        return baseConfigService.queryConfig();
    }


}

