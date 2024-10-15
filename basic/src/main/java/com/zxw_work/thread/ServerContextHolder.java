package com.zxw_work.thread;

import com.zxw_work.entity.Request;
import com.zxw_work.entity.Response;

/**
 * @Author: Ryan
 * @Date: 2024/9/14 16:41
 * @Version: 1.0
 * @Description: 上下文持有
 *
 *                  总结：
 *                      ?和泛型接收都一样，但是返回使用时，泛型可以直接用对用的类型接收，而?则需要强转；
 */
public class ServerContextHolder {

    public static final ThreadLocal<ServerContext<? extends Request, ? extends Response>> threadLocal =
            new ThreadLocal();

    /*
    写法一不 ok，变量定义不能加泛型定义不识别（<Req extends Request, Res extends Response>），变量泛型直接再类型后面，但是需要类定义，见写法二
    public static final <Req extends Request, Res extends Response> ThreadLocal<ServerContext<Req, Res>>  _threadLocal = new ThreadLocal<>();

    写法二 ok，配合 public class ServerContextHolder<R extends Request, Resp extends Response> {
    public final ThreadLocal<ServerContext<R, Resp>> __threadLocal = new ThreadLocal();
    */

    public static <Req extends Request, Res extends Response> void setG(ServerContext<Req, Res> context) {
        threadLocal.set(context);
    }

    public static void set(ServerContext<? extends Request, ? extends Response> context) {
        threadLocal.set(context);
    }

    // 写法一 ok（推荐），使用方便 ServerContext<XxxReq, XxxRes> current = ServerContextHolder.getCurrent();
    public static <Req extends Request, Res extends Response> ServerContext<Req, Res> get() {
        return (ServerContext<Req, Res>) threadLocal.get();
    }

    // 写法二 ok，使用需要强转 ServerContext<XxxReq, XxxRes> serverContext = (ServerContext<XxxReq, XxxRes>) ServerContextHolder.getUnknown();
    public static ServerContext<? extends Request, ? extends Response> getUnknown() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }

}
