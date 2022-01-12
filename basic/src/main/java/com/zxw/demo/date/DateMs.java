package com.zxw.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2021/12/2 17:18
 * @Version: 1.0
 * @Description: 查看毫秒数
 */
public class DateMs {

    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date time = c.getTime();
        System.out.println(time);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(time));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date()));
    }
}
