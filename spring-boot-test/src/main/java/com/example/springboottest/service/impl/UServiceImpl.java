package com.example.springboottest.service.impl;

import com.example.springboottest.entity.U;
import com.example.springboottest.mapper.UMapper;
import com.example.springboottest.service.UService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 17:29
 * @Version: 1.0
 * @Description:
 */
@Service
public class UServiceImpl implements UService {

    @Resource
    UMapper uMapper;

    @Override
    public U userBooksGet(Integer uId) {
        return uMapper.selectUserBooks(uId);
    }

    @Override
    public List<U> usersBooksGet() {
        return uMapper.selectUsersBooks();
    }

    @Override
    public PageInfo<U> usersBooksPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum == null || pageNum <= 0 ? 1 : pageNum, pageSize == null || pageSize <= 0 ? 10 : pageSize );

        List<U> us = uMapper.selectUPage();

        return new PageInfo<>(us);

    }
}
