package cn.itcast.demo.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Ryan
 * @Date: 2020/7/13 9:55
 * @Version: 1.0
 * @Description: （同步）线程演示类
 */
public class Ticket implements Runnable {

    private int ticketNum = 100;

    private int i = 0;

    Object object = new Object(); // 定义锁对象

    private Lock lock = new ReentrantLock(true); //定义锁对象：构造函数参数为线程是否公平获取锁true-公平；false-不公平，即由某个线程独占，默认是false

    @Override
    public void run() {

        // 不同步
//        while (ticketNum > 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + ":" + "第" + ++i + "张票售出，" + "还剩于" + --ticketNum + "张票");
//        }

        // 同步代码块
//        boolean b = true;
//        while (b) {
//            synchronized (object) {
//                if (ticketNum > 0) {
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + ":" + "第" + ++i + "张票售出，" + "还剩于" + --ticketNum + "张票");
//                } else {
//                    b = false;
//                }
//            }
//        }

        // 同步方法块
//        while (ticketNum > 0) {
//            sellTicket();
//        }

        // lock 锁
        while (ticketNum > 0) {
            lock.lock(); // 加锁
            try {
                if (ticketNum > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + ":" + "第" + ++i + "张票售出，" + "还剩于" + --ticketNum + "张票");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock(); // 放锁
            }
        }
    }


    private synchronized void sellTicket() {
        if (ticketNum > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + "第" + ++i + "张票售出，" + "还剩于" + --ticketNum + "张票");
        }
    }
}
