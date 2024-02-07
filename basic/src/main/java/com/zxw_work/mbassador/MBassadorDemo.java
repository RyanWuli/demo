package com.zxw_work.mbassador;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.listener.Handler;

/**
 * @Author: Ryan
 * @Date: 2024/1/31 14:24
 * @Version: 1.0
 * @Description: MBassadorDemo 时间总线用例
 */
public class MBassadorDemo {

    private static final MBassador<String> dispatcher = new MBassador<>();

    private static String message;

    public static void main(String[] args) {
        // 指定当前订阅的对象（指定处理器 @Handle）
        dispatcher.subscribe(new MBassadorDemo());

        // 推送发布信息（发布之后，订阅的处理器会进行处理）
        dispatcher.post("testString").now();

        System.out.println("message is:" + message);
    }

//    @Before
//    public void prepare() {
//        dispatcher.subscribe(this);
//    }

    @Handler
    public void handleString(String msg) {
        message = msg;
    }

}
