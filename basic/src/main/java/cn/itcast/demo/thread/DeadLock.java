package cn.itcast.demo.thread;

/**
 * @Author: Ryan
 * @Date: 2020/7/13 14:37
 * @Version: 1.0
 * @Description: 线程死锁演示
 */
public class DeadLock implements Runnable {

    private int flag;

    private static Object object = new Object();
    private static Object object2 = new Object();

    public DeadLock(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == 0) {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "已经获取到资源 object，请求 object2.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + "已经获取到资源 object 和 object2！！！！！");
                }
            }
        } else {
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "已经获取到资源 object2，请求 object.....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + "已经获取到资源 object2 和 object！！！！！");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new DeadLock(0), "线程：");
        Thread thread2 = new Thread(new DeadLock(2), "线程2：");
        thread.start();
        thread2.start();
    }
}
