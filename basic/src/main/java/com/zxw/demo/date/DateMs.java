package com.zxw.demo.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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

        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(new Date().getTime());

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());

//        for (int i = 0; i < 100; i++) {
//            System.out.println(new Random().nextInt(9));
//        }

        for (int i = 0; i < 100; i++) {
            System.out.println(new Random().nextLong());
        }

        String s = "1234567890";
        System.out.println(s.substring(s.length() - 7));
    }
}
