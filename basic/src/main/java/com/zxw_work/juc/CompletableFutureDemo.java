package com.zxw_work.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Ryan
 * @Date: 2024/1/26 15:45
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /* 同步模拟 */
        log.info("sync start ...");
        long syncStart = System.currentTimeMillis();

        method1();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        method2();

        long syncEnd = System.currentTimeMillis();
        log.info("sync end ... time:{}", syncEnd - syncStart);

        /* 异步模拟 */
        log.info("async start ...");
        long asyncStart = System.currentTimeMillis();

        // 这一步执行的时候异步就开始执行了
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(CompletableFutureDemo::method1);
        log.info("async future1 time:{}", System.currentTimeMillis() - asyncStart);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("async sleep time:{}", System.currentTimeMillis() - asyncStart);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(CompletableFutureDemo::method2);

        /*
        get 方法会阻塞住，等异步执行完成之后再往下执行
        work.juc.CompletableFutureTest.testCompletableFutureRunAsyncGet
         */
        Void unused1 = completableFuture1.get();
        Void unused2 = completableFuture2.get();

        long asyncEnd = System.currentTimeMillis();
        log.info("async end ... time:{}", asyncEnd - asyncStart);

    }

    private static void method1() {
        try {
            log.info("----- m1 start...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void method2() {
        try {
            log.info("----- m2 start...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
