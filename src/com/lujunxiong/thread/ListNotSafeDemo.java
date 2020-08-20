package com.lujunxiong.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName NotSafeDemo
 * @Author 陆军雄
 * @Date 2020/8/13
 * @Description: 举例说明集合类List是不安全的
 * 1.故障现象
 *      java.util.ConcurrentModificationException
 *
 * 2.导致原因
 *      ArrayList不安全，ArrayList在迭代的时候如果同时对其进行修改就会
 * 3.解决方案
 *      用线程安全的Vector，能保持数据一致性，但性能慢，同一时间段只允许一个人读或写
 *      Collections.synchronizedList(new ArrayList<>())，数据一致性不好，读取效率提升
 *      CopyOnWriteArrayList<>() 写时复制，
 * 4.优化建议(同样的错误，不出现第2次)
 *
 *
 **/
public class ListNotSafeDemo {
    public static void main(String[] args) {
        ////Collections.synchronizedList(new ArrayList<>()); 小数据量的时候，把线程不安全ArrayList的转换成线程安全的ArrayList
        //多线程时用CopyOnWriteArrayList<>()
        List<String> list = new CopyOnWriteArrayList<>();

                //new Vector<>();
        for (int i = 1; i <=30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();

        }
        /*list.add("a");
        list.add("b");
        list.add("c");
        for (String s : list) {
            System.out.println(s);

        }*/
    }
}
