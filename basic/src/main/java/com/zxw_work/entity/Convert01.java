package com.zxw_work.entity;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author: Ryan
 * @Date: 2024/11/8 10:20
 * @Version: 1.0
 * @Description: "xxx" 服务 xxx 功能
 */
public class Convert01 extends AbstractConverter<Req01, Res01, Entity01, Ereq01, Eres01> {

    private final static Map<String, Object> METHOD_INFO = Maps.newHashMap();

    public Convert01() {
        METHOD_INFO.put("xxxx接口名称", Convert01.class);
        METHOD_INFO.put("msg", "xxx msg");
    }

    @Override
    protected Ereq01 buildExternalReq(Req01 req01) {
        Ereq01 ereq = new Ereq01();
        // do yourself
        return ereq;
    }

    @Override
    protected Response<Res01> convertExternalRes(Eres01 eres01) {
        Res01 eres = new Res01();
        // do yourself
        return new Response<>(eres);
    }
}
