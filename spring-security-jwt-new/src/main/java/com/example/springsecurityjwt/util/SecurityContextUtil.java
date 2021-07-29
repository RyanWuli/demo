package com.example.springsecurityjwt.util;

import com.example.springsecurityjwt.entity.Users;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Create by Ryan on 2021/2/5 20:48
 * Version 1.0
 * Description security 上下文工具类
 */
public class SecurityContextUtil {

    /**
     * 从上下文中获取用户 id
     * @return
     */
    public static Long getUserId() {
        return ((Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
    }
}
