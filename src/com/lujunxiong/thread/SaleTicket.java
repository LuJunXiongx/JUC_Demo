package com.lujunxiong.thread;

/**
 * @ClassName SaleTicket
 * @Author 陆军雄
 * @Date 2020/8/11
 * @Description: 题目：三个售票员  卖出  30张票
 * 多线程编程的企业级套路+模板
 * 1、在高内聚低耦合的前提下：线程    操作（对外暴露的调用方法）   资源类
 **/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 */
class Ticket {
    private int number = 30;
    //ReentrantLock 可重复锁
    private Lock lock = new ReentrantLock();

    //synchronized 同一时间段只有一个线程能够进来
    public void saleTicket() {

        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t卖出第：" + (number--) + "\t还剩下：" + number);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            lock.unlock();
        }


    }
}

public class SaleTicket {

    public static void main(String[] args) throws Exception {
        Ticket ticket = new Ticket();

        new Thread(()->{for (int i = 0; i <= 30; i++)  ticket.saleTicket(); },"A").start();
        new Thread(()->{for (int i = 0; i <= 30; i++)  ticket.saleTicket(); },"B").start();
        new Thread(()->{for (int i = 0; i <= 30; i++)  ticket.saleTicket(); },"C").start();


        /*//匿名内部类
        new Thread(new Runnable() {
            //调用strat()方法还没立即启动，只是准备就绪，等待资源调度，不知道什么时候启动
            @Override
            public void run() {
                for (int i = 0; i <= 30; i++) {
                    ticket.saleTicket();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 30; i++) {
                    ticket.saleTicket();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 30; i++) {
                    ticket.saleTicket();
                }
            }
        }, "C").start();*/


    }
}
