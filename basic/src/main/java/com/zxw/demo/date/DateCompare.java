package com.zxw.demo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Ryan
 * @Date: 2022/4/2 14:53
 * @Version: 1.0
 * @Description: add the description
 */
public class DateCompare {

    public static void main(String[] args) throws ParseException, InterruptedException {
        Date date = new Date();

        Date date2 = new Date();

        Thread.sleep(1000);

        Date date3 = new Date();
        System.out.println(date2.compareTo(date3));

        System.out.println(date2.getTime() == date3.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = sdf.format(date);
        Date date1 = sdf.parse(format);

        System.out.println(date.compareTo(date1));
        System.out.println(date.getTime() == date1.getTime());
    }
}
