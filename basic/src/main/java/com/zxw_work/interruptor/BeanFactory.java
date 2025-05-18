package com.zxw_work.interruptor;

import com.zxw_work.biz.MyBiz;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: Ryan
 * @Date: 2024/11/5 15:21
 * @Version: 1.0
 * @Description: 实例工厂（基于拦截器、代理实现）
 */
@Slf4j
public class BeanFactory {

    // 单例工厂对象
    private static volatile BeanFactory beanFactory;

    // 实例容器
    public final Map<String, Object> beanMap = new HashMap<>();

    // 这里通过构造器来实例化 bean，应用的时候可以结合 spring 来动态加载
    // 私有化构造器
    private BeanFactory() {
        // 这里简单点，直接加载某个包指定包的数据，应用的时候可以根据某个类，比如 spring 的启动类开始，逐步往下找
        String packageName = MyBiz.class.getPackage().getName();
        // 包路径
        String packagePath = packageName.replace(".", "/");
        Enumeration<URL> resources = null;

        try {
            resources = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        } catch (IOException e) {
            log.info("加载包{}资源异常，e:", packageName, e);
            return;
        }

        // 包的文件结构，是否有更多的元素（这个包下还有其它包没有）
        boolean hasMoreElements = resources.hasMoreElements();

        if (hasMoreElements) {
            // 有文件则继续
//            log.info("element:{}", resources.nextElement());
            loadMyClass(resources.nextElement(), packageName);
        } else {
            // 无则异常吧或者什么都不做
            log.info("包{}不存在, 请检查...", packageName);
        }
    }

    /**
     * 加载类
     * @param url
     *          统一资源定位符（资源相关信息封装）
     */
    private void loadMyClass(URL url, String packageName) {
        // 文件地址
        String file = url.getFile();
        // 包文件夹
        File directory = new File(file);

        // 文件夹不存在
        if (!directory.exists()) {
            log.info("包{}对应的文件夹不存在", file);
            return;
        }

        for (File f : Objects.requireNonNull(directory.listFiles())) {
            String fileName = f.getName();
            if (!fileName.endsWith(".class")) {
                // 不是 class 文件跳过
                log.info("文件：{}不是 class 文件，跳过加载", fileName);
                continue;
            }

            // MyBiz
            String className = fileName.replace(".class", "");

            String fullClassName = packageName + "." + className;

            Class<?> aClass;
            try {
                aClass = Thread.currentThread().getContextClassLoader().loadClass(fullClassName);
            } catch (ClassNotFoundException e) {
                log.info("类{}加载失败", fullClassName);
                return;
            }

            Method[] methods = aClass.getDeclaredMethods();

            // 是否有拦截
            boolean isInterrupt = false;

            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                for (Annotation annotation : annotations) {
                    if (annotation.annotationType() == Interruptor.class) {
                        isInterrupt = true;
                        break;
                    }
                }
            }

            Object o;

            try {
                o = aClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            // 有拦截方法需要代理
            if (isInterrupt) {
                o = ProxyHandler.getInstance(o);
            }

            beanMap.put(fullClassName, o);
        }

    }

    /**
     * 工厂初始化
     *
     * @return BeanFactory
     *              工厂对象
     */
    public static BeanFactory instance() {
        // DCL-双检锁
        if (null == beanFactory) {
            synchronized (BeanFactory.class) {
                if (null == beanFactory) {
                    beanFactory = new BeanFactory();
                }
            }
        }
        return beanFactory;
    }

    /**
     * 获取 bean 实例
     * @param tClass 类型
     * @return 实例
     */
    public <T> T getBean(Class<?> tClass) {
        String typeName = tClass.getName();
        return (T) beanMap.get(typeName);
    }

}
