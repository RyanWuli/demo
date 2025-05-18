package com.example.springboottest.autotask;

import cn.hutool.core.lang.UUID;
import com.example.springboottest.entity.AutoTask;
import com.example.springboottest.enums.AutoTaskType;
import com.example.springboottest.mapper.AutoTaskMapper;
import com.example.springboottest.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2024/12/18 15:51
 * @Version: 1.0
 * @Description: 自动任务支撑类
 */
@Slf4j
@Component
public class AutoTaskSupport {

    @Autowired
    private AutoTaskPolicy autoTaskPolicy;

    @Autowired
    private AutoTaskMapper autoTaskMapper;

    /**
     * 保存自动任务并执行任务
     * <p>
     * 此方法可以再业务中进行使用
     */
    public void storeThenExecute(AutoTask autoTask) {
        autoTaskMapper.insert(autoTask);

        // 事务之后再执行，insert 会产生事务，也就是说确保 insert 提交之后再执行处理；
        SpringUtil.afterCommitCall(() -> autoTaskPolicy.call(autoTask));
    }

    /**
     * 构建默认 autoTask 实例
     */
    public AutoTask buildDefAutoTask(String orderNo, String identify, AutoTaskType autoTaskType) {
        AutoTask autoTask = new AutoTask();
        autoTask.setTaskType(autoTaskType);
        autoTask.setIdentify(identify);
        autoTask.setNextExecuteTime(new Date());
        autoTask.setBizNo(UUID.fastUUID().toString());
        autoTask.setOrderNo(orderNo);
        return autoTask;
    }

}
