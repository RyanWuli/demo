package cn.itcast.demo.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: Ryan
 * @Date: 2020/7/14 9:51
 * @Version: 1.0
 * @Description: 模拟 CountDownLatch ，教练和运动员（运动员准备，教练等待，运动员准备完成，然后教练开始训练）
 */
public class CountDownLatchDemo {
    // 模拟等待三个运动员准备
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    /**
     * 运动员准备
     */
    public void racer() {
        // 获取线程名
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在准备.....");
        try {
            Thread.sleep(1000); // 模拟准备过程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "准备完毕！");
        // 计数
        countDownLatch.countDown();
    }

    /**
     * 教练
     */
    public void coach() {
        // 获取线程名
        String name = Thread.currentThread().getName();
        System.out.println(name + "正在等待运动员准备.....");
        try {
            countDownLatch.await(); // 等待运动员们准备
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "准备完毕，开始训练！");
    }

    public static void main(String[] args) {

        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();

        // 创建线程
        Thread thread = new Thread(countDownLatchDemo::coach, "教练");
        Thread thread2 = new Thread(countDownLatchDemo::racer, "运动员2");
        Thread thread3 = new Thread(countDownLatchDemo::racer, "运动员3");
        Thread thread4 = new Thread(countDownLatchDemo::racer, "运动员4");

        // 启动线程
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
