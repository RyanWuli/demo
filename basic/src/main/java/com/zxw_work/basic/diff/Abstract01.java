package com.zxw_work.basic.diff;

/**
 * @Author: Ryan
 * @Date: 2024/12/4 9:39
 * @Version: 1.0
 * @Description: add the description
 */
public abstract class Abstract01 {

    protected String a;

    /**
     * 抽象方法，继承类必须实现
     */
    protected abstract void method01();

    /**
     * 非抽象方法，继承类可重写非必须
     */
    protected void method02() {
        // do something
    }

}
