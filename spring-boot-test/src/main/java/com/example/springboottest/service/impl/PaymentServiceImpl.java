package com.example.springboottest.service.impl;

import com.example.springboottest.entity.Payment;
import com.example.springboottest.mapper.PaymentMapper;
import com.example.springboottest.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author: Ryan
 * @Date: 2021/2/24 14:43
 * @Version: 1.0
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentMapper paymentMapper;

    @Override
    public void paymentAdd() {
        Payment payment = new Payment();
        payment.setSerial(String.valueOf(new Date()));
        int i = paymentMapper.insertPayment(payment);
        System.out.println("result-i" + i);
        System.out.println("payment-id:" + payment.getId());
    }
}
