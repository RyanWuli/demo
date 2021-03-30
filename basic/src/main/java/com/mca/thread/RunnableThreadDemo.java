package com.mca.thread;

/**
 * @Author: Ryan
 * @Date: 2021/3/13 17:30
 * @Version: 1.0
 * @Description:
 */
public class RunnableThreadDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("---------------->线程:" + Thread.currentThread().getName() + "-----" + i);
        }
    }

    public static void main(String[] args) {

        RunnableThreadDemo runnableThreadDemo = new RunnableThreadDemo();
        Thread thread = new Thread(runnableThreadDemo);
        Thread thread2 = new Thread(runnableThreadDemo);
        thread.start();
        thread2.start();

        for (int i = 0; i < 10000000; i++) {
            System.out.println("---------------->线程:" + Thread.currentThread().getName() + "-----" + i);
        }
    }


}
