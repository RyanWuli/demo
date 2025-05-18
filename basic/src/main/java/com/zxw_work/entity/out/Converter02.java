package com.zxw_work.entity.out;

import com.google.common.collect.Maps;
import com.zxw_work.entity.*;

import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/11/8 10:20
 * @Version: 1.0
 * @Description: "10000001" 服务 用户查询 功能
 */
public class Converter02 extends AbstractConverter<Req02, Res02, Entity02, Ereq02, Eres02> {

    private final static Map<String, Object> METHOD_INFO = Maps.newHashMap();

    public Converter02() {
        METHOD_INFO.put("userQuery", Converter02.class);
        METHOD_INFO.put("msg", "模拟的用户查询接口构建转换器 msg");
    }

    @Override
    protected Ereq02 buildExternalReq(Req02 req01) {
        Ereq02 ereq = new Ereq02();
        // do yourself
        return ereq;
    }

    @Override
    protected Response<Res02> convertExternalRes(Eres02 eres01) {
        Res02 res = new Res02();
        // do yourself
        return new Response<>(res);
    }
}
