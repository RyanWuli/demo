package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.common.RestResult;
import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.util.SecurityContextUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

/**
 * Create by Ryan on 2021/2/5 20:35
 * Version 1.0
 * Description explain
 */
@RequestMapping("/test")
@RestController
public class TestController {

    @GetMapping("/info")
    public RestResult getInfo() {
        Users users = (Users)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return RestResult.success(users);
    }

    @GetMapping("/userid")
    public RestResult getUserInfo() {
        Long userId = SecurityContextUtil.getUserId();
        return RestResult.success(userId);
    }
}
