package com.zxw.demo;

import javax.sound.midi.Soundbank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2020/10/20 10:39
 * @Version: 1.0
 * @Description: 日期测试
 */
public class DateTest {

    /**
     * 计算指定时间是星期几
     * @param args
     * @throws ParseException
     */
//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2020-10-15");
//        System.out.println(date);
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        System.out.println(calendar);
//        String[] week = {"周日","周一","周二","周三","周四","周五","周六"};
//        System.out.println("指定时间是：" + week[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
//    }

    /**
     * 时间转换方式
     */
//    public static void main(String[] args) throws ParseException {
//        Date d = new Date();
//        System.out.println(d);
//        long time = d.getTime();
//        System.out.println(time);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2020-12-12");
//        Date parse = sdf.parse("2021-01-10");
//        System.out.println(date.getTime());
//        System.out.println(parse.getTime());
//    }


    /**
     * localtime 和 localDate
     * @param args
     * @throws ParseException
     */
//    public static void main(String[] args) throws ParseException {
//        Date now = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date d = sdf.parse("2021-03-05");
//        System.out.println("----------------> d:" + d);
//        LocalTime t = LocalTime.now();
//        System.out.println(t);
//
//        LocalDate date = LocalDate.now();
//        System.out.println(date);
//        LocalDate parse = LocalDate.parse(sdf.format(d));
//        System.out.println("--------------------> parse:" + parse);
//    }
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf.parse("2021-03-05");
        int i = LocalDate.now().compareTo(LocalDate.parse("2021-03-05"));
        System.out.println("--------------------> i:" + i);
    }



}
