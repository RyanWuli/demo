package cn.itcast.demo.thread;

import javax.activation.MailcapCommandMap;
import java.util.concurrent.Semaphore;

/**
 * @Author: Ryan
 * @Date: 2020/7/14 11:14
 * @Version: 1.0
 * @Description: 模拟8个工人使用3台机器
 */
public class SemaphoreDemo implements Runnable {

    private int workerNO;
    private Semaphore semaphore;

    public SemaphoreDemo(int no, Semaphore sem) {
        this.workerNO = no;
        this.semaphore = sem;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // 请求机器
            String name = Thread.currentThread().getName();
            System.out.println("工号为" + workerNO + "的工人请求机器，正在使用机器...");
            Thread.sleep(1000); // 模拟使用机器过程
            System.out.println("工号为" + workerNO + "的工人使用机器完毕！");
            semaphore.release(); // 释放机器
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int workerNum = 8; // 八个工人
        Semaphore semaphore = new Semaphore(3); // 3台机器
        for (int i = 0; i < workerNum; i++) {
            new Thread(new SemaphoreDemo(i, semaphore)).start();
        }
    }
}
