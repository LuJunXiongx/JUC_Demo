package com.lujunxiong.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName MapNotSafeDemo
 * @Author 陆军雄
 * @Date 2020/8/13
 * @Description: 举例说明集合类Map是不安全的
 * java.util.ConcurrentModificationException
 * new HashMap()等价于new HashMap(16,0.75)  16*0.75=12 到12会扩容一倍32  2的n次方 把初始值设大一点，避免扩容操作，
 **/
public class MapNotSafeDemo {
    public static void main(String[] args) {
        //HashMap的底层一个个Node结点  到8的时候变成红黑树
        Map<String,String> map = new ConcurrentHashMap<>();
        //Collections.synchronizedMap();
        // new HashMap<>();
        Map<String,String> map2 = new HashMap<>();

        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}
