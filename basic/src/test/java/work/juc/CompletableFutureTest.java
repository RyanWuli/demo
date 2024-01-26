package work.juc;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Ryan
 * @Date: 2024/1/26 15:43
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class CompletableFutureTest {

    @Test
    public void testCompletableFutureRunAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        log.info("----- start time:{}", start);
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(CompletableFutureTest::method1);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(CompletableFutureTest::method2);
        completableFuture1.get();
        Thread.sleep(10000);
        completableFuture2.get();
        long end = System.currentTimeMillis();
        log.info("----- end time:{}, total time:{}", end, end - start);
    }

    @Test
    public void testCompletableFutureRunAsyncGet() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        log.info("----- start time:{}", start);

        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(CompletableFutureTest::method1);
        CompletableFuture<Void> completableFuture2 = CompletableFuture.runAsync(CompletableFutureTest::method2);

        completableFuture2.get();
        log.info("completableFuture2 get time:{}", System.currentTimeMillis() - start);

        completableFuture1.get();
        log.info("completableFuture1 get time:{}", System.currentTimeMillis() - start);


        long end = System.currentTimeMillis();
        log.info("----- end time:{}, total time:{}", end, end - start);
    }

    private static void method1() {
        try {
            log.info("----- m1 start...");
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void method2() {
        try {
            log.info("----- m2 start...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
