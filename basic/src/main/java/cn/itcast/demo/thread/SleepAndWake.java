package cn.itcast.demo.thread;

import java.util.PriorityQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Ryan
 * @Date: 2020/7/13 16:59
 * @Version: 1.0
 * @Description: 线程休眠和唤醒
 */
public class SleepAndWake {

    private Object object = new Object();
    private int i = 0;

    // 同步代码块实现
//    public void odd() { // 输出奇数的方法
//        while (i < 10) {
//            synchronized (object) { // notify 和 wait 必须和同步线程使用
//                if (i % 2 == 1) { // 奇数则输出
//                    System.out.println("奇数" + i);
//                    i++;
//                    object.notify(); // 当在一个对象实例上调用wait()方法后，当前线程就会在这个对象上等待。直到另外的线程调用了notify()方法，出于等待的线程才得以继续进行。这样，多线程之间的协作就可以用这两个方法进行通信了。
//                } else { // 不是奇数则等待
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//    public void even() {
//        while (i < 10) {
//            synchronized (object) { // notify 和 wait 必须和同步线程使用
//                if (i % 2 == 0) { // 偶数则输出
//                    System.out.println("偶数" + i);
//                    i++;
//                    object.notify(); // 当在一个对象实例上调用wait()方法后，当前线程就会在这个对象上等待。直到另外的线程调用了notify()方法，出于等待的线程才得以继续进行。这样，多线程之间的协作就可以用这两个方法进行通信了。
//                } else { // 不是奇数则等待
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }

    // lock 加锁的方式
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void odd() { // 输出奇数的方法
        while (i < 10) {
            try {
                lock.lock();
                if (i % 2 == 1) { // 奇数则输出
                    System.out.println("奇数" + i);
                    i++;
                    condition.signal();
                } else { // 不是奇数则等待
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public void even() {
        while (i < 10) {
            try {
                lock.lock();
                if (i % 2 == 0) { // 偶数则输出
                    System.out.println("偶数" + i);
                    i++;
                    condition.signal();
                } else { // 不是奇数则等待
                    condition.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final SleepAndWake sleepAndWake = new SleepAndWake();
        Thread thread = new Thread(sleepAndWake::odd, "奇数线程");
        Thread thread2 = new Thread(sleepAndWake::even, "偶数线程");
        thread.start();
        thread2.start();
    }
}
