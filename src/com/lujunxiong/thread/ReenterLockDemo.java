package com.lujunxiong.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReenterLockDemo
 * @Author 陆军雄
 * @Date 2020/8/23
 * @Description: ReenterLock学习：可重入锁（递归锁）
 * 指的是统一线程外层函数获得锁之后，内层递归函数仍然能够获取该锁的代码
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 * <p>
 * <p>
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 **/
class Phone1 implements Runnable {
    private Lock lock = new ReentrantLock();

    public synchronized void sendSms() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tsendSms");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\tsendEmail");
    }

    @Override
    public void run() {
        get();
    }

    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tget");
            set();
        } finally {
            lock.unlock();
        }
    }

    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\tset");
        } finally {
            lock.unlock();
        }
    }

}

public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone1 phone1 = new Phone1();

        new Thread(() -> {
            try {
                phone1.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                phone1.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        Thread t3 = new Thread(phone1);
        Thread t4 = new Thread(phone1);
        t3.start();
        t4.start();

    }

}
