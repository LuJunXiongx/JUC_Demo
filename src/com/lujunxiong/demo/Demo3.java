package com.lujunxiong.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Demo3
 * @Author 陆军雄
 * @Date 2020/7/27
 * @Description: 正确的将数组转换为ArrayList
 **/
public class Demo3 {
    public static void main(String[] args) {
        List list = new ArrayList<>(Arrays.asList("a","b","c"));
        System.out.println("list = " + list);

        Integer[] myArray = {1,2,3};
        List myList = Arrays.stream(myArray).collect(Collectors.toList());
        System.out.println("myList = " + myList);

        //基本类型也可以实现转换(依赖boxed的封箱操作)
        int[] myArray2 = {1,2,3};
        List myList1 = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        System.out.println("myList1 = " + myList1);
    }

}
