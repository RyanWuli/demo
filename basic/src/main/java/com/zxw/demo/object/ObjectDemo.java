package com.zxw.demo.object;

import com.alibaba.fastjson.JSON;
import com.zxw.entity.Singer;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/5/21 9:17
 * @Version: 1.0
 * @Description: add the description
 */
@Slf4j
public class ObjectDemo {

    public static void convertDefault() {
        String singerJson = "{\n" +
                "  \"signCompany\": \"JVR\",\n" +
                "  \"age\": 36\n" +
                "}";

        Singer singer = JSON.parseObject(singerJson, Singer.class);

        log.info("singer:{}", singer);

    }

}
