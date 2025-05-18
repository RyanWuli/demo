package com.zxw_work.juc.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author: Ryan
 * @Date: 2024/10/31 13:56
 * @Version: 1.0
 * @Description: 自定义线程池
 */
@Slf4j
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory factory,
                                RejectedExecutionHandler handler) {

        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, factory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        log.info("线程池统一前置执行方法，当前线程：{}", t.getName());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        log.info("线程池统一后置执行方法...");
    }
}
