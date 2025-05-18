package com.example.springboottest.entity;

import com.example.springboottest.entity.wrapper.MapJson;
import com.example.springboottest.enums.AutoTaskType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2024/12/17 15:36
 * @Version: 1.0
 * @Description: 自动任务类
 */
@Getter
@Setter
public class AutoTask {

    private String orderNo;
    private String bizNo;
    private String identify;
    private AutoTaskType taskType;
    private Integer maxCount = Integer.MAX_VALUE;
    private Integer currentCount = 0;
    private Date nextExecuteTime = new Date();
    private MapJson<String, String> content = new MapJson<>();

    public void addCount() {
        this.currentCount++;
    }

}
