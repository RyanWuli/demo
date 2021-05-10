package com.example.springsecurityjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Ryan
 * @Date: 2021-01-01 23:20:22
 * @Version: 1.0
 * @Description:
 */
@Controller
public class BasicHttpController {

    /**
     * 登陆成功之后的首页
     * @return
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 用户管理
     * @return
     */
    @GetMapping("/system/user")
    public String userList() {
        return "user";
    }

    /**
     * 角色管理
     * @return
     */
    @GetMapping("/system/role")
    public String roleList() {
        return "role";
    }

    /**
     * 菜单管理
     * @return
     */
    @GetMapping("/system/menu")
    public String menuList() {
        return "menu";
    }

    /**
     * 订单管理
     * @return
     */
    @GetMapping("/order")
    public String orderList() {
        return "order";
    }

    /**
     * 退出功能
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        return "../public/login";
    }
}
