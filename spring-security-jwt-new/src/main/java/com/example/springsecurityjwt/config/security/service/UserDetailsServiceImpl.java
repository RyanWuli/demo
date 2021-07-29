package com.example.springsecurityjwt.config.security.service;

import com.example.springsecurityjwt.entity.Users;
import com.example.springsecurityjwt.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by Ryan on 2021/1/5 19:06
 * Version 1.0
 * Description explain
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userService.getUserByUserName(s);
        if (user == null) throw new UsernameNotFoundException("用户：" + s + "不存在！！！");
        // 将数据库的 roles 解析为 UserDetails 的权限集合
        // AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()) 将逗号分隔的字符集转成权限对象列表
        user.setAuthorities(AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRoles()));
        return user;
    }
}
