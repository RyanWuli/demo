package com.example.springboottest.mapper;

import com.example.springboottest.entity.AutoTaskHis;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 15:18
 * @Version: 1.0
 * @Description: 自动任务 mapper
 */
@Mapper
public interface AutoTaskHisMapper {

    // FIXME: 2024/12/17 16:35 完善

    int insert(AutoTaskHis autoTaskHis);

}
