package com.zxw_work.juc.executor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Ryan
 * @Date: 2024/10/31 15:02
 * @Version: 1.0
 * @Description: 线程池工厂
 */
public class MyThreadPoolExecutorFactory {

    public static final String MY_POOL_NAME = "myPool";

    private static volatile MyThreadPoolExecutorFactory factory;

    private final Map<String, ThreadPoolExecutor> poolMap = new HashMap<>();

    /**
     * 私有构造方法
     */
    private MyThreadPoolExecutorFactory() {
        // 这里简单一点，直接 put 就行，开发可以结合 spring boot 的注解等去动态加载
        // 这个线程池变量不要更改，测试是基于这个配置测试分析的，如果需要其它配置，可以重新新建一个线程池
        poolMap.put(MY_POOL_NAME, new MyThreadPoolExecutor(5, 15, 60,
                TimeUnit.MINUTES, new LinkedBlockingQueue<>(50), new MyThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()));
    }

    /**
     * 实例化
     * @return 线程池工厂
     */
    private static MyThreadPoolExecutorFactory instance() {
        if (null == factory) {
            synchronized (MyThreadPoolExecutorFactory.class) {
                if (null == factory) {
                    factory = new MyThreadPoolExecutorFactory();
                }
            }
        }

        return factory;
    }

    /**
     * 获取线程池
     *
     * @param poolName 线程池名称
     * @return 线程池实例
     */
    public static ThreadPoolExecutor getPoolExecutor(String poolName)  {
        return instance().poolMap.get(poolName);
    }
}
