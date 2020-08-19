package com.lujunxiong.thread;

/**
 * @ClassName SingletonDemo
 * @Author 陆军雄
 * @Date 2020/8/19
 * @Description: 在单例模式用到了volatile
 * 多线程下单例模式是不安全的
 * 也可以加synchronized，变成线程安全了
 * DCL单例模式
 **/
public class SingletonDemo {
    private static SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "\t 我是构造方法SingletonDemo()");
    }
    //DCL（Double check Lock双端检测锁机智）,只用加同步代码块
    public static  SingletonDemo getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo.class){
                if (instance ==null){
                    instance = new SingletonDemo();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
//        System.out.println();
        //并发线程后，情况发生了很大变化
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();

        }
    }
}
