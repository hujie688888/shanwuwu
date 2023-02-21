package com.example.shanwuwu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class DemoController {

    @RequestMapping("index")
    public String index(){
        return  "Success  三汪旺，2023-02-21 明天继续加油";
    }


}
