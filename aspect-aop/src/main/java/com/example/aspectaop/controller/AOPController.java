package com.example.aspectaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ryan
 * @Date: 2020/10/6 10:30
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/aop")
public class AOPController {

    @GetMapping(value = "/get")
    public String aop(String str) {
        System.out.println(">>>>>>>>>>>>>>>>>>> aop test");
        return ">>>>>>>>>>>>>>>>>>> aop test " + str;
    }
}
