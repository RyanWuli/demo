package com.zxw.demo.Class;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Ryan
 * @Date: 2025/6/12 9:30
 * @Version: 1.0
 * @Description: 内部类相关 demo
 *
 * <ul>
 *     <li>内部类本身就是类的一个属性（按照属性的方式去理解）</li>
 * </ul>
 */
@Slf4j
public class InnerClassDemo {

    private String str = "str";

    private static String staStr = "staStr";

    public void visit() {
        log.info("成员方法执行...");

        // 成员内部类，在成员方法中，只能在方法中使用
        class memberInner {
            public void visit() {
                log.info("局部内部类访问成员变量：{}", str);
            }
        }

        new memberInner().visit();

        /*
        匿名内部类（没有名字）lambda 表达式就是特殊的匿名内部类

        必须继承抽象类或实现接口
        不能定义任何静态变量和方法
         */
        Service service = new Service() {
            @Override
            public void method() {
                log.info("匿名内部类访问成员变量：{}", str);
            }
        };

        service.method();
    }

    public static class StaticInner {
        public void visit() {
            // 静态内部类中只能访问外部类的静态变量
            log.info("静态内部类访问静态变量：{}", staStr);
        }
    }

    public class Inner {
        public void visit() {
            // 成员内部类可以访问静态或非静态的变量
            log.info("成员内部类访问静态变量：{}", staStr);
            log.info("成员内部类访问成员变量：{}", str);
        }
    }

    interface Service {
        void method();
    }

}
