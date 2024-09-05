package com.zxw_work.proxy.dynamic;

/**
 * @Author: Ryan
 * @Date: 2024/5/10 9:35
 * @Version: 1.0
 * @Description: 售卖实现
 */
public class SaleImpl implements Sale {
    @Override
    public void sellComputer() {
        System.out.println("sell computer...");
    }

    @Override
    public void sellPhone() {
        System.out.println("sell phone...");
    }

    @Override
    public void sellMp3() {
        System.out.println("sell mp3..,");
    }
}
