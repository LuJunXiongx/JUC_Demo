package com.lujunxiong.thread;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName CASDemo
 * @Author 陆军雄
 * @Date 2020/8/20
 * @Description: CAS：比较并交换   ====>compareAndSet
 *期望值和真实值比较，如果相等，就更新
 **/
public class CASDemo {
    public static void main(String[] args) {
        //真实值
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //update：更新值
        System.out.println(atomicInteger.compareAndSet(5,2020)+"\t current data：" +atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data：" +atomicInteger.get());
        atomicInteger.getAndIncrement();
        new HashMap<>();

    }

}
