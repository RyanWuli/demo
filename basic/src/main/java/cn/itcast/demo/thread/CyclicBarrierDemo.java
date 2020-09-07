package cn.itcast.demo.thread;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: Ryan
 * @Date: 2020/7/14 10:40
 * @Version: 1.0
 * @Description:
 */
public class CyclicBarrierDemo {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public void startThread() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备...");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + "已经准备完毕，启动：" + new Date().getTime());
    }

    public static void main(String[] args) {
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo();
        Thread thread = new Thread(cyclicBarrierDemo::startThread, "线程");
        Thread thread2 = new Thread(cyclicBarrierDemo::startThread, "线程2");
        Thread thread3 = new Thread(cyclicBarrierDemo::startThread, "线程3");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
