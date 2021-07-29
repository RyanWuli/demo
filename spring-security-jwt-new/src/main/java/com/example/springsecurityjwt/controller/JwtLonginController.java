package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.common.RestResult;
import com.example.springsecurityjwt.config.security.service.UserAuthService;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create by Ryan on 2021/2/2 21:35
 * Version 1.0
 * Description explain
 */
@RestController
public class JwtLonginController {

    @Resource
    UserService userService;

    @Resource
    UserAuthService userAuthService;

    /**
     * 登录方法
     * @param username 用户名
     * @param password 密码
     * @return 结果
     */
    @PostMapping({"/login", "/"})
    public RestResult login(String username, String password) {
        RestResult result = RestResult.success();
        String token = userAuthService.login(username, password);
        result.put("token", token);
        return result;
    }
}
