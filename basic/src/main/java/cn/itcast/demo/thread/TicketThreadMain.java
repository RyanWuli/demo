package cn.itcast.demo.thread;

/**
 * @Author: Ryan
 * @Date: 2020/7/13 10:16
 * @Version: 1.0
 * @Description: （同步）线程演示 main
 */
public class TicketThreadMain {

    public static void main(String[] args) {
        Ticket ticket = new Ticket(); // 线程对同一个对象操作，才存在线程安全与不安全
        Thread thread = new Thread(ticket, "线程");
        Thread thread2 = new Thread(ticket, "线程2");
        Thread thread3 = new Thread(ticket, "线程3");
//        Thread thread4 = new Thread(ticket, "线程4");
//        Thread thread5 = new Thread(ticket, "线程5");
//        Thread thread6 = new Thread(ticket, "线程6");
        thread.start();
        thread2.start();
        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
    }
}
