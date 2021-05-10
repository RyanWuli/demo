package com.example.springboottest.mapper;

import com.example.springboottest.entity.Payment;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 14:54
 * @Version: 1.0
 * @Description: PaymentMapper
 */
public interface PaymentMapper {

    /**
     * 保存 payment
     * @param payment payment 对象
     * @return 保存结果
     */
    int insertPayment(Payment payment);
}
