package com.zxw.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @Author: Ryan
 * @Date: 2025/6/5 16:01
 * @Version: 1.0
 * @Description: add the description
 */
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class Singer extends Person {

    private String signCompany;

    // 重写父类的属性
    private Integer age = 15;

    /**
     * 子类如果继承父类需要默认父类值需要在构造方法中直接设置默认就行
     * FastJson 转新生成对象测试可行
     */
    public Singer() {
        setName("周杰伦");
    }
}
