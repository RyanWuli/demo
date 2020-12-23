package com.example.springboottest.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Ryan
 * @Date: 2020/10/22 9:20
 * @Version: 1.0
 * @Description: 测试定时任务
 */
@Slf4j
@Component
@EnableScheduling
public class TaskBasic {

    @Scheduled(cron = "0/5 * * * * ?")
    public void taskTest() throws InterruptedException {
        String name = Thread.currentThread().getName();
        log.info(">>>>>>>>>>>>>>> 线程：" + name);
        log.info(">>>>>>>>>>>>>>>>>>> 时间" + LocalDateTime.now());
        Thread.sleep(10000);
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void taskTest2() {
        String name = Thread.currentThread().getName();
        log.info(">>>>>>>>>>>>>>> 2 线程：" + name);
        log.info(">>>>>>>>>>>>>>>>>>> 2 时间" + LocalDateTime.now());
    }
}
