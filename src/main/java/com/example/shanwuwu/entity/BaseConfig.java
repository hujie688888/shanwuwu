package com.example.shanwuwu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

@Data
public class BaseConfig {
    private int setMeal;

    private int preferentialPrice;

    private  int originalPrice;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date expiresDate;

    private  String id;
}
