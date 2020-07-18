package cn.itcast.demo.thread;

/**
 * @Author: Ryan
 * @Date: 2020/7/14 15:39
 * @Version: 1.0
 * @Description: 模拟两个线程同时转账，互不干涉
 */
public class ThreadLocalDemo {

    static class Bank {
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
        public Integer get() {
            return threadLocal.get();
        }
        public void set() {
            threadLocal.set(threadLocal.get() + 10);
        }
    }

    static class Transfer implements Runnable {

        Bank bank;

        public Transfer(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bank.set();
                System.out.println(Thread.currentThread().getName() + bank.get());
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Transfer transfer = new Transfer(bank);
        Thread thread = new Thread(transfer, "客户：");
        Thread thread2 = new Thread(transfer, "客户2：");
        thread.start();
        thread2.start();
    }
}
