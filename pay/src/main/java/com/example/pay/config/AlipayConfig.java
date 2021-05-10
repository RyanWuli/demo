package com.example.pay.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author: Ryan
 * @Date: 2021/4/1 16:38
 * @Version: 1.0
 * @Description:
 */
@Configuration
public class AlipayConfig {

    @Resource
    private AlipayProperties alipayProperties;

    @Bean
    public AlipayClient initAlipayClient() {
        return new DefaultAlipayClient(alipayProperties.getGatewayUrl(),
                alipayProperties.getAppId(), alipayProperties.getAppPrivateKey(),
                alipayProperties.getFormat(), alipayProperties.getCharset(),
                alipayProperties.getAlipayPublicKey(), alipayProperties.getSignType());
    }
}
