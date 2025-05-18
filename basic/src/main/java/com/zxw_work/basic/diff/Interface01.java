package com.zxw_work.basic.diff;

/**
 * @Author: Ryan
 * @Date: 2024/12/4 9:21
 * @Version: 1.0
 * @Description: 接口和抽象类的区别
 */
public interface Interface01 {

    /**
     * 接口属性默认都是 public static final 的，可省略
     * 其它的 protected、private 都不支持
     */
    public static final String A = "A";

    String B = "B";

    /**
     * 接口方法都是 public，可省略
     * 必须加上关键字 default
     * 可以被继承，但是不必需
     * 默认方法出现是 JDK 1.8 开始
     * 由于一前的接口只能有抽象方法（继承必须实现），所以接口扩展的时候，需要把所有的实现类都进行实现新方法（有些实现类根本不需要），所以扩展性
     *      捉襟见肘了，引入默认方法则解决了这个问题，实现类可根据自身需求去决定是否使用或者重写
     */
    public default void method01() {
        // do something
    }

    default void method02() {
        // do something
    }

}
