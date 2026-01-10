package com.zxw.demo.extend;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Ryan
 * @Date: 2021/4/28 17:04
 * @Version: 1.0
 * @Description:
 */
@Getter
@Setter
public class Father {

    int i = 1;
    String name = "father";
    /**
     * 父类的私有变量，子类不能继承（使用取值的角度来说），但是内存中是存在的（从这个角度来说也是能继承的），但是一般就是从使用角度来说
     */
    private String address = "中国";


    public static void main(String[] args) {
        Father father = new Father();
        Father f = new Child();
        f.i = 2;
        f.name = "child";
        System.out.println(father.i + father.name);
        System.out.println(f.i + f.name);
    }

}
