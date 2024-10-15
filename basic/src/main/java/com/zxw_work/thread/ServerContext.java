package com.zxw_work.thread;


import com.zxw_work.entity.Request;
import com.zxw_work.entity.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Ryan
 * @Date: 2024/9/14 16:49
 * @Version: 1.0
 * @Description: 服务上下文参数
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class ServerContext<Req extends Request, Res extends Response> {

    private Req req;

    private Res res;

}
