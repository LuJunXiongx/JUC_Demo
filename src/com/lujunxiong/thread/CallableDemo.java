package com.lujunxiong.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName CallableDemo
 * @Author 陆军雄
 * @Date 2020/8/13
 * @Description: 多线程中，第3种获得多线程的方式
 **/
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*******come in here");
        return 1024;
    }
}
public class CallableDemo  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }

}
