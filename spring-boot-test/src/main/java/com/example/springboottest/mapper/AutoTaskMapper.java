package com.example.springboottest.mapper;

import com.example.springboottest.entity.AutoTask;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 15:18
 * @Version: 1.0
 * @Description: 自动任务 mapper
 */
@Mapper
public interface AutoTaskMapper {

    // FIXME: 2024/12/17 16:35 完善

    AutoTask lockByBizNo(String bizNo);

    int insert(AutoTask autoTask);

    int update(AutoTask autoTask);

    int delete(AutoTask autoTask);

}
