package com.example.springboottest.annotation;

import com.example.springboottest.entity.Payment;

import java.lang.annotation.*;

/**
 * @Author: Ryan
 * @Date: 2024/11/13 10:16
 * @Version: 1.0
 * @Description: spel(Spring EL) 测试用注解
 *                  只支持 Spel 表达式取数据，例如 #p0.name 取上下文的值（支持 String/Integer/enum/自定义类等）
 *                  这里只是 Spel 表达式，所以所有的属性定义都是 String 类型，具体类型需要看 Spel 取出来的类型
 *                  解析数据参考 {@link com.example.springboottest.demo.aop.SpelAspect}
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SpelA {


    /**
     * <p>
     *     Spel 取出 Integer 类型
     *     p0.name
     *     实体中 name 是 String 类型
     */
    String strVaule() default "";

    /**
     * 只能定义基础类，包装类(Integer)不行，注解类型
     * <p>
     *     Spel 取出 Integer 类型
     *     p0.age
     *     实体中 age 是 int 类型
     */

    String intValue() default "";

    /**
     * 只能定义基础类，包装类(Boolean)不行，注解类型
     * <p>
     *     Spel 取出 Boolean 类型
     *     p0.right
     *     实体中 right 是 boolean 类型
     */
    String booValue() default "";

    /**
     * <p>
     *     Spel 取出 enum 类型
     *     p0.defaultValue
     *     实体中 defaultValue 是 enum 类型
     */
    String enumValue() default "";

    /**
     * 不能定义 实体类 Payment classValue();(注解类型)
     * <p>
     *     Spel 取出自定义实体类型
     *     p0.payment
     *     实体中 payment 是 自定义 类型 {@link Payment}
     */
    String objValue() default "";

    /**
     * <p>
     *     Spel 取出字符串比较结果（Boolean）
     *     p0.name eq 'Ryan'
     *     实体中 name 是 String 类型，这里取出的是比较结果 Boolean 类型
     */
    String strCompareValue() default "";

    /**
     * <p>
     *     Spel 取出枚举比较结果（Boolean）
     *     p0.defaultStatus == T(com.example.springboottest.enums.DefaultStatus).SUCCESS
     *     实体中 defaultStatus 是 枚举 类型，这里取出的是比较结果 Boolean 类型
     */
    String enumComparevalue() default "";

}
