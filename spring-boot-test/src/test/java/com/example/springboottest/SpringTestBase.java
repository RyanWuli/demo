package com.example.springboottest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author: Ryan
 * @Date: 2024/1/26 17:41
 * @Version: 1.0
 * @Description: spring boot test base
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootTestApplication.class)
public class SpringTestBase {
}
