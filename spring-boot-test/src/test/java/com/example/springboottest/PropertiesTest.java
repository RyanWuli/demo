package com.example.springboottest;

import com.example.springboottest.config.PropertiesConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2024/1/26 9:32
 * @Version: 1.0
 * @Description: spring 配置参数用例
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootTestApplication.class)
public class PropertiesTest {

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Test
    public void propertiesTest() {
        System.out.println("properties test value:" + propertiesConfig.getTestValue());
        System.out.println("properties init test value:" + PropertiesConfig.TEST_VALUE);
    }

    @Autowired
    private TaskScheduler taskScheduler;

    @Test
    public void testAutowired() {
        System.out.println(taskScheduler);
    }

}
