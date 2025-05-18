package com.example.springboottest.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.springboottest.annotation.SpelA;
import com.example.springboottest.entity.Entity01;
import com.example.springboottest.service.SpelTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: Ryan
 * @Date: 2024/11/28 17:44
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
@Service
public class SpelTestServiceImpl implements SpelTestService {

    @SpelA(strVaule = "#p0.name", intValue = "#p0.age", booValue = "#p0.right", enumValue = "#p0.defaultStatus",
            objValue = "#p0.payment", strCompareValue = "#p0.name eq 'Ryan'",
            enumComparevalue = "#p0.defaultStatus == T(com.example.springboottest.enums.DefaultStatus).SUCCESS")
    @Override
    public void spelTestMethod1(Entity01 entity01) {
        log.info("执行 spelTestMethod1 方法...entity01:{}", JSON.toJSONString(entity01));
    }
}
