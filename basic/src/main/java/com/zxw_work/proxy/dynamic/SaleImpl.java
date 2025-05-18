package com.zxw_work.proxy.dynamic;

import com.zxw_work.interruptor.Interruptor;

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

    @Interruptor
    @Override
    public void sellPhone() {
        System.out.println("sell phone...");
    }

    @Override
    public void sellMp3() {
        System.out.println("sell mp3..,");
    }
}
