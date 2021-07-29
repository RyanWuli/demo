package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.dao.UserDao;
import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Create by Ryan on 2021/1/5 19:00
 * Version 1.0
 * Description explain
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    @Override
    public Users getUserByUserName(String userName) {
        Users user = new Users();
        user.setUserName(userName);
        List<Users> users = userDao.findAll(Example.of(user));
        return users.isEmpty() ? null : users.get(0);
    }
}
