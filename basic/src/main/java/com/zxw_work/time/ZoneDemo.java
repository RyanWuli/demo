package com.zxw_work.time;

import java.time.*;
import java.util.TimeZone;

/**
 * @Author: Ryan
 * @Date: 2024/1/25 11:42
 * @Version: 1.0
 * @Description: 时区相关的学习用例
 */
public class ZoneDemo {

    public static void main(String[] args) {
        // 默认时区ID（时区），
        // 底层是子类 ZoneOffset 或者 ZoneRegion
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("----- zoneId:" + zoneId); // systemDefault:Asia/Shanghai

        // 时区偏移量，可以获取时区
        // ZoneId zoneId = ZoneId.systemDefault(); 就是通过 TimeZone 获取
        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("----- timeZone:" + timeZone); // timeZone:sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=31,lastRule=null]

        // 带时区的日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("----- zonedDateTime:" + zonedDateTime); // zonedDateTime:2024-01-25T18:58:17.732+08:00[Asia/Shanghai]

        // 指定日期和时间获取带时区的时间
        LocalDate localDate = LocalDate.now();
        System.out.println("----- localDate:" + localDate); // localDate:2024-01-25
        LocalTime localTime = LocalTime.now();
        System.out.println("----- localTime:" + localTime); // localTime:18:58:17.732
        LocalDate localDate1 = LocalDate.of(2024, 1, 25);
        LocalTime localTime1 = LocalTime.of(15, 25, 55, 555);
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(localDate1, localTime1, zoneId);
        System.out.println("----- zonedDateTime1:" + zonedDateTime1); // zonedDateTime1:2024-01-25T15:25:55.000000555+08:00[Asia/Shanghai]

        // 时间以及偏移量，但是不包含时区
        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("----- offsetDateTime:" + offsetDateTime); // offsetDateTime:2024-01-25T19:05:09.980+08:00
    }

}
