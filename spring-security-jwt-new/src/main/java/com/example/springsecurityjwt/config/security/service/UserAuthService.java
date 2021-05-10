package com.example.springsecurityjwt.config.security.service;

import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by Ryan on 2021/2/3 22:28
 * Version 1.0
 * Description explain
 */
@Service
public class UserAuthService {

    @Resource
    AuthenticationManager authenticationManager;

    @Resource
    JwtTokenUtil jwtTokenUtil;

    /**
     * 登录认证换取 jwt 令牌
     * @param username 用户名
     * @param password 密码
     * @return 令牌
     */
    public String login(String username, String password) {
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用 UserDetailsServiceImpl.loadUserByUserName
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new RuntimeException("用户名密码错误");
        }
        Users user = (Users) authentication.getPrincipal();
        return jwtTokenUtil.generateToken(user);
    }
}
