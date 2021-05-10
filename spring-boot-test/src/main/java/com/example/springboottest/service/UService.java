package com.example.springboottest.service;

import com.example.springboottest.entity.U;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 17:27
 * @Version: 1.0
 * @Description: 用户 接口
 */
public interface UService {

    /**
     * 获取用户以及书本,一对多单条
     * @param uId
     * @return
     */
    U userBooksGet(Integer uId);

    /**
     * 一对多列表，全部 一 （不适用）
     * @return
     */
    List<U> usersBooksGet();

    /**
     * 一对多 分页
     * @return 分页信息
     */
    PageInfo<U> usersBooksPage(Integer pageNum, Integer pageSize);
}
