package cn.itcast.demo.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Ryan
 * @Date: 2020/7/16 10:04
 * @Version: 1.0
 * @Description: 可重入锁示例
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            reentrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "加锁" + (i + 1) + "次！");
        }
        for (int i = 0; i < 3; i++) {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + "解锁" + (i + 1) + "次！");
        }
    }
}
