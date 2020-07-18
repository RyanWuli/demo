package cn.itcast.demo.thread;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Ryan
 * @Date: 2020/7/16 10:10
 * @Version: 1.0
 * @Description:
 */
public class ReadWriteLockDemo {

    private Map<String, Object> map = new HashMap<>();
    // 创建一个读写锁实例
    private ReadWriteLock rw = new ReentrantReadWriteLock();
    // 创建一个读锁
    private Lock r = rw.readLock();
    // 创建一个写锁
    private Lock w = rw.writeLock();

    /**
     * 读操作
     * @param key
     * @return
     */
    public Object get(String key) {

        try {
            r.lock();
            System.out.println(Thread.currentThread().getName() + "读操作开始执行.....");
            Thread.sleep(3000);
            return map.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return e.getMessage();
        } finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName() + "读操作执行完成！");
        }
    }

    public void put(String key, Object value) {

        try {
            w.lock();
            System.out.println(Thread.currentThread().getName() + "写操作正在执行.....");
            Thread.sleep(3000);
            map.put(key, value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName() + "写操作执行完成！");
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo rwd = new ReadWriteLockDemo();
        new Thread(() -> rwd.put("key", "value"), "写线程：").start();
        new Thread(() -> rwd.put("key2", "value2"), "写线程2：").start();
        new Thread(() -> rwd.put("key3", "value3"), "写线程3：").start();
        new Thread(() -> rwd.get("key"), "读线程：").start();
        new Thread(() -> rwd.get("key2"), "读线程2：").start();
        new Thread(() -> rwd.get("key3"), "读线程3：").start();
    }
}
