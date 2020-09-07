package com.zxw.supermall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zxw.supermall.mapper")
public class SupermallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermallApplication.class, args);
    }

}
