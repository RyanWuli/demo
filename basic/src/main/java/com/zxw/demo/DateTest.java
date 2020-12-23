package com.zxw.demo;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2020/10/20 10:39
 * @Version: 1.0
 * @Description: 日期测试
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse("2020-10-15");
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);
        String[] week = {"周日","周一","周二","周三","周四","周五","周六"};
        System.out.println("指定时间是：" + week[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
    }
}
