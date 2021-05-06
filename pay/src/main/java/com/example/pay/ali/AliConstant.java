package com.example.pay.ali;

/**
 * @Author: Ryan
 * @Date: 2021/4/1 15:05
 * @Version: 1.0
 * @Description:
 */
public class AliConstant {

    //支付宝移动端appid
    public static final String ALIPAY_APP_APPID = "2016110100783373";
    //支付宝商户私钥merchant
    public static final String  MERCHANT_PRIVATE_KEY="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDJa0Thek2lQ1175W+xzlMiSMa45OY+gDT9tkOCjWn4RLRIgypaVmY51s3q5F2cniAMgy435utBGRrvSQjo3lGTFck8tu+IbqQwRd946nBxrXg1YSAS66kpXegPfsEidt9484f+9Nd0pmbXy7p8N/L1U1XnsfVqkw3JLnWDlw/XTBwtBajS+/Gwtjvl7iX40L6DfQH6dLdxwscV9ElMsa+N5QMaVWZmeBCEp26e+BnKRoYw7nWiJTyttOlK+xtxygOrni8LQBdaUrf284jKkAGPHH4I/i/tdEDHaLERO6okh80IiFw9AlUgIImb/EBYogALZ7goxgpofiNlwkWd71L/AgMBAAECggEBAI7u02uaqf0MCAwC7jdkbjRXJsZQkV9rBa/Bpri/d6LZxoHqqqR+yX5kA66brh6VS7L1aFf9Q5bnpOiHkI4ILiVNgYfXXbYYpeUnwIUDARZ6fmKK8QLcPyf+3s4YKiA18THYx/pSb471AuhCR60c2wniwIRyEfE2N8M7d+MQ0Qn7U2t9gpXAzBaswrAzfM92H0rcEQWw3i8/AicSk4WSy7G8eka12+Pvxn8DXgt+ZboSMM8cZ/ucG3LfBfirdRNfNhLbCG112a0/73QE6Q7wkr/Ki/gpqbHLgKZ6rVDCqQ5z/OLYBDpehufXOnlEMtEEG1Kw801CFBm6jpcoD4cI5nkCgYEA6AWfaJj0HjADsHCj50Yg/8uekic3MsPsqQn0RhHDhIO121ns+T7nyjUhLOcAIJZSRoFZT7zHbJLl5unUE0WTjl1N48IQF4LDaRiZSIAqIVRoBxHyrTz2l5UD2Y3In2brWHYIF0imdjsEJX45d/9gV2+fpfZ3c1LhSmxRwDVPzyMCgYEA3jwDq2YWPOrvoHET/IzVBIQYvdvk4RVQuTVoILvW7/1Ug7tG5Ra4tAMOVv6VhJS9swmaUPgNzGlKNRsIfn0HZyRwoboB1mXSS2gNZAV+ejj4KTQxBlg8QOFZQYMbtTMKF9O7AKKtoNLbaeYYXerDnRavgRtDSvle6JveoV2iOHUCgYEAmoncMivmNREf8+4ijVFde2KhHJG4JzzuLWzu4ZjFVEbx4scTmrO2aS1YCnNV116oMEPJO93uKjfxnwrRcYCfFmy5C2FfnHlBNIfo2Kxc41Q38bWXoKGBUVc0eDwCi4Fecc4z92YxUYBfc6WOG4niHnq/qCfwScTDP/HDxbT8kmcCgYAmzmwFngn8ETpO1fAbhawc4cRAQwmwlDxIWx8XuDVMKvx7FFTI5DLUnEQAxOvu/toxTVf5E5e1Ph2LMHFHRSXpyN8yHnz7p0QVjtHnyV3Qkeojp813wiijW7ZuTiqkdYkpp/tbnQycrLVLxLY0kC4gXDnBXbVefjUogS9bFjKhkQKBgHhZbTTCSgVQArK334JkvaOcX3Z8CwS/uQZoInJz/juKE4BQWV5ejKsZDyCT3f6UtemoXOZceIjEqF3rfb6byFRsahgHspWfqhdLBI0KmkATY3c/9AwtW/+C6wO0RbrCEKCwneBtWBlkfJHIiaP2poS2UQLzNDBtOqqRGlV5feWH";

    //支付宝公钥
    public static final String ALIPAY_PUBLIC_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiQoiJi9XOA0xp4pVkYCIlqAlFYbYBHjFWhHWMceUmqsIHMR7xG0CPLA41LIs1ELCr8zeP2LPwsUrIO9QU/Bz0amHzFbA0PI8Lm6oiRzyhytpTo317dsjhsYdqOxOTc8nJYAsqtZuqUwcN4h6odbBdoT68dxFb7cp6RRl2dfRpUidDPUp2VJ2BjnAWu0dX+dYWeweWW7+VvEB9WaWAnqUJLghx2SkILnJRzz8f2FTTZwDews8r6XMULn95hJAcvts5HDWQl9l/K0MyBcEiQTqbliySzZ4cbflIJHSzsvkGbAjIXrYXTmLAXi4XqRGv2AScGbuRwAKO0hTeK2A5Ci3rwIDAQAB";
    //支付宝网关
    public static final String ALIPAY_GATEWAY_URL = "https://openapi.alipaydev.com/gateway.do";
    // 验证方式
    public static final String SIGN_TYPE = "RSA2";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static  final String NOTIFY_URL = "https://www.alipay.com";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，沙箱环境下可以填写本地地址
    public static final String RETURN_URL = "https://www.baidu.com/?tn=99205150_hao_pg";
    // 传输方式
    public static final String FORMAT = "json";
    // 字符串格式
    public static final String CHARSET = "UTF-8";
    public static final String REFUND_METHOD = "alipay.trade.refund";

    public static final String NOTIFY_URL = "http://118.25.11.110:8082/chwl";

}
