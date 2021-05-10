package com.example.springboottest.mapper;

import com.example.springboottest.entity.U;

import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 17:20
 * @Version: 1.0
 * @Description: 测试用户 mapper
 */
public interface UMapper {

    /**
     * 获取用户以及用户的书本
     * @param uId 用户 id
     * @return 用户对象包括书本
     */
    U selectUserBooks(Integer uId);

    /**
     * 获取一对多列表
     * @return 列表
     */
    List<U> selectUsersBooks();

    /**
     * 一对多 分页
     * @return 分页结果
     */
    List<U> selectUPage();
}
