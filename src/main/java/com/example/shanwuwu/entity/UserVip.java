package com.example.shanwuwu.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserVip {

    private int setMeal;

    private int preferentialPrice;

    private  int originalPrice;

    private Date expiresDate;

    private  String id;

    private  String userId;

    private  String configId;

}
