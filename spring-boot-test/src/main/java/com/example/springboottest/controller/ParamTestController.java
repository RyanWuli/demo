package com.example.springboottest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ryan
 * @Date: 2021/3/13 9:49
 * @Version: 1.0
 * @Description:
 */
@RestController
@RequestMapping("/param-test")
@Slf4j
public class ParamTestController {

    @GetMapping("/get")
    public String paramTest(String name) {
        log.info("-----------------------> name:" + name);
        log.info("------------------------> name 等于 空？-{}", name == null);
        return name;
    }
}
