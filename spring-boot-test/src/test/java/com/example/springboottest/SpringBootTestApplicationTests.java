package com.example.springboottest;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.example.springboottest.entity.*;
import com.example.springboottest.entity.pojo.Actor;
import com.example.springboottest.enums.DefaultStatus;
import com.example.springboottest.factory.TestFactory;
import com.example.springboottest.mapper.ActorMapper;
import com.example.springboottest.service.PaymentService;
import com.example.springboottest.service.SpelTestService;
import com.example.springboottest.test.AnnotationComponent;
import com.example.springboottest.test.SpringTextComponent;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@SpringBootTest
class SpringBootTestApplicationTests {

    @Resource
    PaymentService paymentService;

    public static Snowflake snowflake = IdUtil.getSnowflake(1, 1);

    /**
     * spring 对象复制
     */
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

    /**
     * spring 对象复制
     *
     * null 也会被复制（慎用）
     */
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

    /**
     * spring 对象复制
     *
     * 不同类型不会异常，有相同属性复制没有则不复制
     */
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

    @Autowired
    private SpringTextComponent springTextComponent;

    /**
     * ApplicationContext
     */
    @Test
    void testApplication() {
        springTextComponent.applicationText();
    }

    /**
     * 工厂获取 bean 对象
     */
    @Test
    void testFactory() {
        ((AnnotationComponent) TestFactory.instance().getBean("annotationComponent")).method();
    }

    @Test
    void testAnnotation() {

    }

    @Autowired
    @Qualifier("mulThreadExecutor")
    private ThreadPoolTaskExecutor mulThreadExecutor;

    /**
     * completableFuture 用例
     *
     * 使用指定线程池 mulThreadExecutor
     *  1.线程池 corePoolSize 足够，则并行
     *  2.corePoolSize 不够，maxPoolSize 足够，不一定会新开线程并行，还要看 queueCapacity 参数（队列）；
     *      如果有空间会先放队列中，排队等 corePoolSize 已有线程机进行执行；如果队列满了，才会新开线程（不超过 maxPoolSize）
     */
    @Test
    void testCompletableFuture() throws ExecutionException, InterruptedException {
        List<CompletableFuture<Void>> list = Lists.newArrayList();

        long s = System.currentTimeMillis();

        for (int i = 0; i < 2; i++) {
            list.add(CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(5000);
                    log.info("线程-{}", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, mulThreadExecutor));
        }

        // 调用 get() 时候才会阻塞等待执行完成
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).get();

        long e = System.currentTimeMillis();

        log.info("end...time:{}", e - s);

    }

    @Autowired
    private SpelTestService spelTestService;

    @Test
    public void testSpelAop() {
        Entity01 entity01 = new Entity01();
        entity01.setName("Ryan");
        entity01.setAge(15);
        entity01.setRight(true);
        entity01.setDefaultStatus(DefaultStatus.PROCESSING);
        entity01.setPayment(new Payment(1, "1234567"));
        spelTestService.spelTestMethod1(entity01);
    }

    @Autowired
    private ActorMapper actorMapper;

    @Test
    public void testMapper() {
        Actor actor = new Actor();
        actor.setActorId((short) 1);
        Actor act = actorMapper.selectById(actor);
        log.info("act:{}", JSON.toJSONString(act));
    }

}
