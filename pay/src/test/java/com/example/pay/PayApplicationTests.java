package com.example.pay;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayFundTransUniTransferModel;
import com.alipay.api.domain.Participant;
import com.alipay.api.request.AlipayFundTransUniTransferRequest;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipayFundTransUniTransferResponse;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.example.pay.config.AlipayProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class PayApplicationTests {

    @Resource
    public AlipayClient alipayClient;

    @Resource
    public AlipayProperties alipayProperties;

    @Test
    void contextLoads() {
    }


//    void aliPayTest() throws AlipayApiException {
//        CertAlipayRequest certAlipayRequest   =   new   CertAlipayRequest ();
//        certAlipayRequest . setServerUrl ( gateway );
//        certAlipayRequest . setAppId ( app_id );
//        certAlipayRequest . setPrivateKey ( app_privateKey );
//        certAlipayRequest . setFormat ( "json" );
//        certAlipayRequest . setCharset ( charset );
//        certAlipayRequest . setSignType ( sign_type );
//        certAlipayRequest . setCertPath ( app_cert_path );
//        certAlipayRequest . setAlipayPublicCertPath ( alipay_cert_path );
//        certAlipayRequest . setRootCertPath ( alipay_root_cert_path );
//        DefaultAlipayClient alipayClient   =   new   DefaultAlipayClient ( certAlipayRequest );
//        AlipayFundTransUniTransferRequest request   =   new   AlipayFundTransUniTransferRequest ();
//        request . setBizContent ( "{"   +
//                "\"out_biz_no\":\"201806300001\","   +
//                "\"trans_amount\":1.68,"   +
//                "\"product_code\":\"TRANS_ACCOUNT_NO_PWD\","   +
//                "\"biz_scene\":\"DIRECT_TRANSFER\","   +
//                "\"order_title\":\"201905代发\","   +
//                "\"payee_info\":{"   +
//                "\"identity\":\"2088123412341234\","   +
//                "\"identity_type\":\"ALIPAY_USER_ID\","   +
//                "\"name\":\"黄龙国际有限公司\","   +
//                "    },"   +
//                "\"remark\":\"201905代发\","   +
//                "\"business_params\":\"{\\\"payer_show_name\\\":\\\"服务代理\\\"}\""   +
//                "  }" );
//        AlipayFundTransUniTransferResponse response   =   alipayClient . certificateExecute ( request );
//        if ( response . isSuccess ()){
//            System . out . println ( "调用成功" );
//        }  else  {
//            System . out . println ( "调用失败" );
//        }
//
//    }

    /**
     * 支付宝转账
     * @throws AlipayApiException
     */
    @Test
    void aliPayTransferTest() throws AlipayApiException {

        System.out.println("-------------> alipayConfig" + alipayClient);
        System.out.println("-------------> alipayProperties" + alipayProperties);

        AlipayFundTransUniTransferModel model = new AlipayFundTransUniTransferModel();
        model.setOutBizNo(UUID.randomUUID().toString());
        model.setBizScene("DIRECT_TRANSFER");
        model.setTransAmount("10000");
        model.setProductCode("TRANS_ACCOUNT_NO_PWD");
//        model.setProductCode("STD_RED_PACKET");

        Participant payer = new Participant();
        payer.setIdentityType("ALIPAY_USER_ID");
        payer.setIdentity("2088102181578683");
        model.setPayerInfo(payer);

        Participant payee=new Participant();       //收款方账户
        payee.setIdentityType("ALIPAY_LOGON_ID");  //标识类型，ALIPAY_USER_ID：支付宝的会员ID ALIPAY_LOGON_ID：支付宝登录号，邮箱、手机等
        payee.setIdentity("klnihw3709@sandbox.com");
        payee.setName("klnihw3709");         //标识类型为ALIPAY_LOGON_ID需设置name

        model.setPayeeInfo(payee);

        AlipayFundTransUniTransferRequest request = new AlipayFundTransUniTransferRequest();
        request.setBizModel(model);

        AlipayFundTransUniTransferResponse response = alipayClient.execute(request);
        System.out.println("---------------> result:" + JSONObject.toJSONString(response));
    }

    @Test
    void aliPayGetUserInfo() {

        System.out.println(alipayClient);

        /*
        ************************** 获取 access_token ****************************
         */
        try {
            AlipaySystemOauthTokenRequest request = new AlipaySystemOauthTokenRequest();
            System.out.println("request:" + request);
            request.setGrantType("authorization_code");
            request.setCode("4b203fe6c11548bcabd8da5bb087a83b");
            AlipaySystemOauthTokenResponse response = alipayClient.execute(request);
            System.out.println(JSONObject.toJSONString(request));

            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }

            String accessToken = response.getAccessToken();

            /*
             ************************ 获取 用户信息 ********************************
             */

            AlipayUserInfoShareRequest req = new AlipayUserInfoShareRequest();
            AlipayUserInfoShareResponse res = alipayClient.execute(req,accessToken);

//            String userId = res.getUserId();

            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
