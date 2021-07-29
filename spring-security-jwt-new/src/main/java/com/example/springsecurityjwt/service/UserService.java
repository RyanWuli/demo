package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Users;

/**
 * Create by Ryan on 2021/1/5 18:58
 * Version 1.0
 * Description explain
 */
public interface UserService {

    public Users getUserByUserName(String userName);
}
