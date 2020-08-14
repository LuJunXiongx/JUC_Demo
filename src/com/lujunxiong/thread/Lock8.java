package com.lujunxiong.thread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Lock8
 * @Author 陆军雄
 * @Date 2020/8/12
 * @Description: 多线程8锁
 * 1.标准访问，请问先打印邮件还是短信？
 * 2.邮件方法暂停4秒钟
 * 3.新增一个普通方法hello()  先打印hello
 *
 *
 *
 *
 * 笔记：一个对象如果有多个synchronized方法，某一个时刻内，只要一个线程去调用其中得一个synchronized方法，
 * 其他得线程只能等待，换句话说，某一个时刻内，只能有唯一一个线程去访问这些synchronized方法
 * 所的是当前对象this，被锁定后，其他线程都不能进入当前对象的其他synchronized方法
 *
 * 加个普通方法后发现和同步锁无关
 * 换成两个对象后，不是同一把锁了，情况立刻变化
 *
 * 都换成静态同步方法后，情况又变了
 * 所有的非静态同步方法用的都是同一把锁-实例对象本身
 *
 * synchronized实现同步的基础：Java中的每一个对象都可以作为锁
 * 具体表现为以下3种形式
 * 对于普通同步方法，锁是当前实例对象
 *
 **/
class Phone{
    //static
    public synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("-----sendEmail");
    }
    public synchronized void sendSMS() throws Exception{
        System.out.println("-----sendSMS");
    }
    public void hello(){
        System.out.println("-----hello");
    }
}
public class Lock8 {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone.sendEmail();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(200);


        new Thread(()->{
            try {
                phone.hello();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"B").start();
    }
}
