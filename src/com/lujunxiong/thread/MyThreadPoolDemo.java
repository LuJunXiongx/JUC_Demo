package com.lujunxiong.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName MyThreadPoolDemo
 * @Author 陆军雄
 * @Date 2020/8/14
 * @Description: 线程池
 * Arrays
 * Collections
 * Executors
 *
 **/
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);//一个池5个受理线程，类似一个银行有5个受理窗口
        //ExecutorService threadPool =  Executors.newSingleThreadExecutor(); //一个银行网点，1个受理业务的窗口
        //一个银行网点，可扩展受理业务的+窗口，一池N个工作线程，类似一个银行有N个受理窗口
        ExecutorService threadPool =  Executors.newCachedThreadPool();

        try {
            //第一种情况，模拟10个顾客来银行办理业务，目前池子里有5个工作人员提供服务
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
