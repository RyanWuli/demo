package com.example.springboottest.handler;

import com.example.springboottest.annotation.AutoTaskHandler;
import com.example.springboottest.autotask.AbstractAutoTaskExecutor;
import com.example.springboottest.entity.AutoTask;
import com.example.springboottest.entity.Payment;
import com.example.springboottest.enums.AutoTaskType;

/**
 * @Author: Ryan
 * @Date: 2024/12/18 9:56
 * @Version: 1.0
 * @Description: 具体业务对应的自动任务处理器
 */
@AutoTaskHandler(autoTaskType = AutoTaskType.XXXXX)
public class XXXXXAutoHandler extends AbstractAutoTaskExecutor<Payment> {
    @Override
    protected Payment convert(AutoTask autoTask) {
        // 这里一般是锁定对应的业务数据
        return null;
    }

    @Override
    protected void doExecute(Payment data, AutoTask autoTask) {
        // do biz
    }
}
