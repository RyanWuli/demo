package com.example.springboottest;

import com.example.springboottest.entity.User;
import com.example.springboottest.entity.UserVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Test
    void contextLoads() {

        User user = new User();
        user.setName("张三");
        user.setTime(new Date());

        UserVo uv = new UserVo();
        BeanUtils.copyProperties(user, uv);

        System.out.println(uv);
    }

    /**
     * 生成200以内的两位小数随机
     */
    @Test
    void testRandom() {
        int max = 200; // 最大值
        int min = 0; // 最小值
        int num = 2; // 保留小数位数
        Runnable a = () -> {
            System.out.println(new BigDecimal(min + Math.random() * (max - min)).setScale(num, BigDecimal.ROUND_HALF_UP));
        };
        int i = 0;
        while (i < 10) {
            new Thread(a).start();
            i++;
        }
    }


}
