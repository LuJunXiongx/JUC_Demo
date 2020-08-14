package com.lujunxiong.demo;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Demo2
 * @Author 陆军雄
 * @Date 2020/7/27
 * @Description: 数组转换为List集合
 **/
public class Demo2 {
    public static void main(String[] args) {
        String[] myArray = {"apple","banana","orange"};
        List<String> myList = Arrays.asList(myArray);
        System.out.println("myList = " + myList);

        //上面两个语句等价于下面一条语句
        List<String> myList1 = Arrays.asList("apple","banana","orange");
        System.out.println("myList1 = " + myList1);


    }
}
