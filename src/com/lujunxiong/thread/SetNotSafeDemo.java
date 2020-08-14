package com.lujunxiong.thread;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName SetNotSafeDemo
 * @Author 陆军雄
 * @Date 2020/8/13
 * @Description: 举例说明集合类Set是不安全的
 **/
public class SetNotSafeDemo {
    public static void main(String[] args) {
        new HashSet<>();
        //new HashSet<>()底层是Hashmap<>()
        //Collections.synchronizedSet(new ArrayList<>());
        //小数据量的时候，把线程不安全ArrayList的转换成线程安全的ArrayList
        //多线程时用CopyOnWriteArraySet<>()
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();

        }
    }
}
