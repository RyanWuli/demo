package com.example.springboottest;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.springboottest.entity.User;
import com.example.springboottest.entity.UserVo;
import com.example.springboottest.entity.Users;
import com.example.springboottest.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
class SpringBootTestApplicationTests {

    @Resource
    PaymentService paymentService;

    public static Snowflake snowflake = IdUtil.getSnowflake(1, 1);

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

    @Test
    void testCopy() {
        User user = new User("user", new Date());
        User u = new User();
        u.setName("u");
        System.out.println("user=" + user);
        System.out.println("u=" + u);
        BeanUtils.copyProperties(u, user);
        System.out.println(">>>>> user" + user);
    }

    @Test
    void testCopy2() {
        Users users = new Users();
        Map<String, Object> map = new HashMap<>();
        map.put("name", "ryan");
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map);
        users.setName(list);
        users.setTime(new Date());

        User user = new User();
        BeanUtils.copyProperties(users, user);

        System.out.println(user);
    }

    @Test
    void testMybatisGetId() {
        paymentService.paymentAdd();
    }

    @Test
    void testSnowFlak() {
        for (int i = 0; i <= 4; i++) {
            System.out.println(snowflake.nextId());
        }
    }


    @Test
    void getSnowFlak() {
        System.out.println(snowflake.nextId());
    }

}
