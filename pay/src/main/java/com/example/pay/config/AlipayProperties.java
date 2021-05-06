package com.example.pay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Ryan
 * @Date: 2021/4/1 16:35
 * @Version: 1.0
 * @Description:
 */
@Data
@Component
@ConfigurationProperties("alipay")
public class AlipayProperties {

    private String appId;
    private String gatewayUrl;
    private String format;
    private String charset;
    private String signType;
    private String appPrivateKey;
    private String alipayPublicKey;

    private String returnUrl;
    private String notifyUrl;
}
