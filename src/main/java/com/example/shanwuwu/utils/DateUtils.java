package com.example.shanwuwu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @projectName: shanwuwu
 * @package: com.example.shanwuwu.utils
 * @className: DateUtils
 * @author: hujie
 * @description: TODO
 * @date: 2023/2/27 12:44
 * @version: 1.0
 */
public class DateUtils {

    public Date computationTime(Date date,int addTime){
        //创建Calendar实例
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);   //设置当前时间
        cal.add(Calendar.MONTH, addTime);  //在当前时间基础上加上多个月
        return cal.getTime();
    }
}
