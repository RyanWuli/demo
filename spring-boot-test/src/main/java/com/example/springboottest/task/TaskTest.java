package com.example.springboottest.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

/**
 * @Author: Ryan
 * @Date: 2020/10/22 15:07
 * @Version: 1.0
 * @Description:
 */
//@Component
//@EnableScheduling
@Slf4j
public class TaskTest {


    @Scheduled(cron = "0/5 * * * * ?")
    public void taskTest2() {
        String name = Thread.currentThread().getName();
        log.info(">>>>>>>>>>>>>>> 3 线程：" + name);
        log.info(">>>>>>>>>>>>>>>>>>> 3 时间" + LocalDateTime.now());
    }

}
