package cn.itcast.demo.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: Ryan
 * @Date: 2020/7/14 16:24
 * @Version: 1.0
 * @Description: 用原子类解决多线程数据不正常(a - 没有原子操作 | b - 原子操作 | c - 解决ABA原子操作)
 */
public class ThreadAtomicDemo {

    //    static int n; // a
//    static AtomicInteger atomicInteger; // b
    static AtomicStampedReference<Integer> atomicStampedReference; // c

    public static void main(String[] args) throws InterruptedException {
        int j = 0;
        while (j < 100) {
//            n = 0; // a
//            atomicInteger = new AtomicInteger(0); // 创建原子类并且设置初始值 // b
            atomicStampedReference = new AtomicStampedReference<Integer>(0, 0); // 参数是初始值和时间戳 // c
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
//                    n++; // a
//                    atomicInteger.getAndIncrement(); // b
                    // c
                    int stamp;
                    Integer reference;
                    do {
                        stamp = atomicStampedReference.getStamp();
                        reference = atomicStampedReference.getReference();
                    } while (!atomicStampedReference.compareAndSet(reference, reference + 1, stamp, stamp + 1));
                }
            });
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
//                    n++; // a
//                    atomicInteger.getAndIncrement(); // 相当于 n++ 操作 // b
                    // c
                    int stamp;
                    Integer reference;
                    do {
                        stamp = atomicStampedReference.getStamp();
                        reference = atomicStampedReference.getReference();
                    } while (!atomicStampedReference.compareAndSet(reference, reference + 1, stamp, stamp + 1));
                }
            });
            thread.start();
            thread2.start();
            thread.join();
            thread2.join();
//            System.out.println("最终结果.....n = " + n); // a
//            System.out.println("最终结果是....." + atomicInteger.get()); // b
            System.out.println("最终结果是....." + atomicStampedReference.getReference());
            j++;
        }
    }
}
