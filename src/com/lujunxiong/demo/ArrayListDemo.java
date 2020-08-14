package com.lujunxiong.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName ArrayListDemo
 * @Author 陆军雄
 * @Date 2020/7/29
 * @Description: TODO
 **/
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        System.out.println("Before add:arrayList.size() = %d\n " + arrayList.size());

        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(9);
        arrayList.add(11);
        System.out.println("Before add:arrayList.size() = %d\n " + arrayList.size());
        //三种遍历方式打印元素
        //第一种：通过迭代器遍历
        System.out.println("通过迭代器遍历：");
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()){
            System.out.println(it.next()+" ");
        }
        System.out.println();

        //第二种：通过索引值遍历
        System.out.println("通过索引值遍历");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i)+" ");
        }
        System.out.println();

        //第三种：for循环遍历
        System.out.println("for循环遍历：");
        for (Integer number : arrayList) {
            System.out.println("number = " + number);
        }

        //toArray用法
        //第一种方式(最常用)
        Integer[] integer = arrayList.toArray(new Integer[0]);

        //第二种
        Integer[] integer1 = new Integer[arrayList.size()];
        arrayList.toArray(integer1);

        


    }
}
