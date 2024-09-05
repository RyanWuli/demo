package com.example.springboottest.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/6/18 10:57
 * @Version: 1.0
 * @Description: 单例工厂
 */
public class TestFactory {

    private volatile static TestFactory factory;

    private static final Map<String, Object> beanMap = new HashMap<>();

    private TestFactory() {
    }

    public static TestFactory instance() {
        if (null == factory) {
            synchronized (TestFactory.class) {
                if (null == factory) {
                    factory = new TestFactory();
                }
            }
        }

        return factory;
    }

    public Object getBean( String k ) {
        return beanMap.get(k);
    }

    public void cacheBean( String k, Object v ) {
        beanMap.put(k, v);
    }
}
