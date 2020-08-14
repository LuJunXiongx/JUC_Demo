package com.lujunxiong.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName Demo4
 * @Author 陆军雄
 * @Date 2020/7/29
 * @Description: 迭代器得使用
 **/
public class Demo4 {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap();
        map.put(1,"JAVA");
        map.put(2,"C++");
        map.put(3,"PHP");
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }

    }
}
