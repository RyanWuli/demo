package com.zxw_work.entity;

/**
 * @Author: Ryan
 * @Date: 2024/11/8 9:25
 * @Version: 1.0
 * @Description: 模拟一个转换器抽象
 */
public abstract class AbstractConverter<Req extends Request, Res extends Result, Entity extends AbstractEntity,
        Ereq extends ExternalReq, Eres extends ExternalRes> {

    /**
     * 模拟构建对外参数
     * @param req
     * @return
     */
    protected abstract Ereq buildExternalReq(Req req);

    /**
     * 模拟构建返回参数转内部参数
     * @param eres
     * @return
     */
    protected abstract Response<Res> convertExternalRes(Eres eres);

}
