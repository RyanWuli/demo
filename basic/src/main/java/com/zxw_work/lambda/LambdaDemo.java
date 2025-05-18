package com.zxw_work.lambda;

import com.google.common.collect.Lists;
import com.zxw.entity.Person;
import com.zxw_work.entity.Money;
import com.zxw_work.entity.Req01;
import com.zxw_work.entity.Req02;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author: Ryan
 * @Date: 2024/1/29 9:19
 * @Version: 1.0
 * @Description: lambda 表达式用例
 *                  Java8BasicTest#test2()
 */
@Slf4j
public class LambdaDemo {

    /**
     * toMap 方法使用（转换为 map 集合）
     */
    public static void main(String[] args) {

        /*
        toMap 转 map 结合 Java8BasicTest#test2()
         */

        /*
        lambda 流式处理数据 list -> map，key 不能重复，否则报错：Duplicate key Person(name=张三, age=15)
        最好是用实体的唯一键去作为 key
         */
//        List<Person> persons = new ArrayList<>();
//        persons.add(new Person("张三", 15));
//        persons.add(new Person("张三", 25));
//        Map<String, Person> map = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity()));
//        log.info("map:{}", map);

        /*
        Collectors.toMap 第三个参数可以指定两个相同 key 值时的处理策略
        (v1, v2) -> v2) 代表重复取后面的
         */
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("张三", 15));
        persons.add(new Person("张三", 25));
        Map<String, Person> map = persons.stream().collect(Collectors.toMap(Person::getName, Function.identity(), (v1, v2) -> v2));
        log.info("map:{}", map);

        /*
        lambda 流式处理数据 list -> map，value 不能为空，否则报错：java.lang.NullPointerException
        如果映射字段的话最好确认不为空
         */
//        List<Person> persons2 = new ArrayList<>();
//        persons2.add(new Person("张三", 15));
//        persons2.add(new Person("李四", null));
//        Map<String, Integer> map2 = persons2.stream().collect(Collectors.toMap(Person::getName, Person ::getAge));
//        log.info("map2:{}", map2);

        /*
        Collectors.toMap 映射 value 值可以进行 null 判断，为空给定默认值防止空指针
        p -> Optional.ofNullable(p.getAge()).orElse(0)
        Optional.ofNullable(p.getAge()).orElse(0) 相当于 if else 逻辑
         */
        List<Person> persons2 = new ArrayList<>();
        persons2.add(new Person("张三", 15));
        persons2.add(new Person("李四", null));
        Map<String, Integer> map2 = persons2.stream().collect(Collectors.toMap(Person::getName, p -> Optional.ofNullable(p.getAge()).orElse(0)));
        log.info("map2:{}", map2);

        /*
        key/value 同同时处理，应该算是最好的方式了，比 Java8BasicTest#test2() 方法更加优雅
         */
        List<Person> persons3 = new ArrayList<>();
        persons3.add(new Person("张三", 15));
        persons3.add(new Person("李四", null));
        persons3.add(new Person("张三", 16));
        Map<String, Integer> map3 = persons3.stream().collect(Collectors.toMap(Person::getName, p -> Optional.ofNullable(p.getAge()).orElse(0), (v1, v2) -> v2));
        log.info("map3:{}", map3);
    }

    /**
     * reduce() 聚合求值 使用 单个参数
     * <p>
     * 把要聚合计算的对象先拿出来.map()，然后再进行聚合.reduce()
     * 这里的 reduce() 用的本身的 add() 方法，会累计到第一个 money 对象上去，改变第一个 money 对象的值
     * 一个参数的情况本质是 m1.m2 两个数计算的结果作为下一次的前一个变量，再与集合中下一个值进行操作，以此类推
     * 第一次的 m1.m2 自然就是集合前两个数
     * 如果集合为空则会返回空，所以返回的是 optional 类，可以配合 orElse 处理空值情况
     */
    public static Money reduce1() {
        Req01 req01 = new Req01(new Money(5));
        Req01 req02 = new Req01(new Money(10));
        Req01 req03 = new Req01(new Money(15));
        ArrayList<Req01> req01s = Lists.newArrayList(req01, req02, req03);
        Money money = req01s.stream().map(Req01::getMoney).reduce(Money::add).orElse(new Money());
        // 两种是一致的只是写法不同
//        Money money1 = req01s.stream().map(Req01::getMoney).reduce((m1, m2) -> m1.add(m2)).orElse(new Money());
        log.info("req01:{}", req01);
        log.info("req02:{}", req02);
        log.info("req03:{}", req03);
        return money;
    }

    /**
     * reduce() 聚合求值 使用 两个参数
     * <p>
     *     两个参数可以定义一个初始值，相当于在第一个参数之前再加一个初始值，然后再进行如同一个参数的方式进行计算操作
     *     两个参数如果集合为空集合的时候会返回初始值而不是 null，这里与一个参数有出入
     */
    public static Money reduce2() {
        Req01 req01 = new Req01(new Money(5));
        Req01 req02 = new Req01(new Money(10));
        Req01 req03 = new Req01(new Money(15));
        ArrayList<Req01> req01s = Lists.newArrayList(req01, req02, req03);
        // 这种是新给一个变量去汇总 (m, m2) -> m 和选择第一个,选第二个的效果一致
//        Money money = req01s.stream().map(Req01::getMoney).reduce(new Money(), Money::add/*, (m, m2) -> m*/);
        Money money = req01s.stream().map(Req01::getMoney).reduce(new Money(), Money::add, (m, m2) -> m2);

        log.info("req01:{}", req01);
        log.info("req02:{}", req02);
        log.info("req03:{}", req03);
        return money;
    }


    /**
     * reduce() 聚合求值 使用 三个参数
     * <p>
     * 三个参数操作的，第二个参数可以操作不是返回类同类的数据类型，也就是说不用先进行 map 映射为需要的类型，更加灵活
     * 由于可能处理的不是返回同类型的数据所以，第一个数据必须传入初始值，然后依次处理到默认值上
     * 第三个参数是并发处理的时候汇总用的
     */
    public static Money reduce3() {
        Req01 req01 = new Req01(new Money(5));
        Req01 req02 = new Req01(new Money(10));
        Req01 req03 = new Req01(new Money(15));
        ArrayList<Req01> req01s = Lists.newArrayList(req01, req02, req03);
        Money money = req01s.stream().reduce(new Money(),
                (sum, req) -> {
                    sum.add(req.getMoney());
                    return sum;
                },
                (m, m2) -> m);

        log.info("req01:{}", req01);
        log.info("req02:{}", req02);
        log.info("req03:{}", req03);
        return money;
    }

    /**
     * reduce() 聚合求值 使用 三个参数 todo 待确认
     * <p>
     *     并行处理 parallel()
     */
    public static Money reduce4() {
        Req01 req01 = new Req01(new Money(5));
        Req01 req02 = new Req01(new Money(10));
        Req01 req03 = new Req01(new Money(15));
        ArrayList<Req01> req01s = Lists.newArrayList(req01, req02, req03);

        for (int i = 0; i < 100; i++) {
            req01s.add(new Req01(new Money(50L)));
        }

        Money money = req01s.stream().parallel().reduce(new Money(),
                (sum, req) -> {
                    sum.add(req.getMoney());
                    return sum;
                },
                Money::add
                // 两种写法等价
                /*(m, m2) -> m.add(m2)*/);

        log.info("req01:{}", req01);
        log.info("req02:{}", req02);
        log.info("req03:{}", req03);
        return money;
    }

    /**
     * reduce() 聚合求值 使用 两个参数 并行处理 todo 待确认
     * <p>
     *     两个参数可以定义一个初始值，相当于在第一个参数之前再加一个初始值，然后再进行如同一个参数的方式进行计算操作
     *     两个参数如果集合为空集合的时候会返回初始值而不是 null，这里与一个参数有出入
     */
    public static Money reduce5() {
        Req01 req01 = new Req01(new Money(5));
        Req01 req02 = new Req01(new Money(10));
        Req01 req03 = new Req01(new Money(15));
        ArrayList<Req01> req01s = Lists.newArrayList(req01, req02, req03);

        for (int i = 0; i < 100; i++) {
            req01s.add(new Req01(new Money(50L)));
        }
        
        // 这种是新给一个变量去汇总 (m, m2) -> m 和选择第一个,选第二个的效果一致
//        Money money = req01s.stream().map(Req01::getMoney).reduce(new Money(), Money::add/*, (m, m2) -> m*/);
//        Money money = req01s.stream().map(Req01::getMoney).reduce(new Money(), Money::add, (m, m2) -> m2);

        Money money = req01s.parallelStream().map(Req01::getMoney).reduce(new Money(), Money::add);

        log.info("req01:{}", req01);
        log.info("req02:{}", req02);
        log.info("req03:{}", req03);
        return money;
    }

    /**
     * reduce() 聚合求值 使用 一个参数 并行处理 todo 待确认
     */
    public static Money reduce6() {
        Req01 req01 = new Req01(new Money(5));
        Req01 req02 = new Req01(new Money(10));
        Req01 req03 = new Req01(new Money(15));
        ArrayList<Req01> req01s = Lists.newArrayList(req01, req02, req03);
        Money money = req01s.stream().parallel().map(Req01::getMoney).reduce(Money::add).orElse(new Money());
        log.info("req01:{}", req01);
        log.info("req02:{}", req02);
        log.info("req03:{}", req03);
        return money;
    }

    /**
     * flatMap() 使用
     * <p>
     *     将 list 中的各个 list 进行合并并操作
     *     返回合并后的 list 的一个 stream
     *     适用于层级集合操作底层集合
     */
    public static List<Money> flatMap1() {
        Req02 req01 = new Req02(Lists.newArrayList(new Money(5), new Money(10), new Money(15)));
        Req02 req02 = new Req02(Lists.newArrayList(new Money(20), new Money(25), new Money(30)));
        Req02 req03 = new Req02(Lists.newArrayList(new Money(35), new Money(40), new Money(45)));

        List<Req02> list = Lists.newArrayList(req01, req02, req03);

        // 统计出所有的 cent
        long sum = list.stream().flatMap(req -> req.getList().stream()).mapToLong(Money::getCent).sum();

        log.info("sum:{}", sum);

        return list.stream().flatMap(req -> req.getList().stream()).collect(Collectors.toList());
    }

}
