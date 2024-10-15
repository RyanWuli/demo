package com.zxw_work.time;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.time.Period;

/**
 * @Author: Ryan
 * @Date: 2024/9/13 15:04
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class PeriodDemo {

    public static void period() {
        Period period = Period.ZERO;
        log.info("periodZero:{}", JSON.toJSONString(period));

        Period of = Period.of(1000, 100, 10);
        log.info("periodOfYMD:{}", JSON.toJSONString(of));
    }

}
