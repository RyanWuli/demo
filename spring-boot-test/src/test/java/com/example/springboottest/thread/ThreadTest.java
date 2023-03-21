package com.example.springboottest.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Create by Ryan on 2023/2/21 22:18
 * Version 1.0
 * Description explain
 */
@Slf4j
@SpringBootTest
public class ThreadTest {

    @Autowired
    @Qualifier("testPool")
    private ThreadPoolTaskExecutor executor;

    @Test
    public void test() throws ExecutionException, InterruptedException {

        log.info("startTime:{}", new Date());

        Future<Integer> f = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 1;
        });

        Future<Integer> f1 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 2;
        });

        log.info("futureEndTime:{}", new Date());

        log.info("sum：{}，endTime：{}", f.get() + f1.get(), new Date());
    }
}
