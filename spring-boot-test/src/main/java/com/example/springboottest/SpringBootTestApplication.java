package com.example.springboottest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MapperScan
 * 指定扫描的 mapper，这里没有在类上面加 @mapper 注解，所以这里要加一个扫描指定路径
 * <p>
 * SpringBootApplication
 * scanBasePackages 此注解属性指定 spring 扫描包的位置，
 * 如果不扫描可能会出现加了注解但是 bean 未加入 spring 的情况，
 * 然后导致使用时 bean 注入不成功抛异常
 */
//
@MapperScan("com.example.springboottest.mapper")
@SpringBootApplication(scanBasePackages = {"com.example.springboottest"})
public class SpringBootTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestApplication.class, args);
    }

}
