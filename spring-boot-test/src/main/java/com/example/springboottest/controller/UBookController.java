package com.example.springboottest.controller;

import com.example.springboottest.service.UService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 17:24
 * @Version: 1.0
 * @Description:
 */
@RequestMapping("/u-book")
@RestController
public class UBookController {

    @Resource
    UService uService;

    @GetMapping("/single")
    public Object UserBooksGet(Integer uId) {
        return uService.userBooksGet(uId);
    }

    @GetMapping("/list")
    public Object userBooksGet() {
        return uService.usersBooksGet();
    }

    @GetMapping("/pages")
    public Object usersBooksPages(Integer pageNum, Integer pageSize) {
        return uService.usersBooksPage(pageNum, pageSize);
    }
}
