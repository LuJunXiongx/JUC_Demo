package com.lujunxiong.demo;

import java.util.Arrays;

/**
 * @ClassName Demo
 * @Author 陆军雄
 * @Date 2020/7/27
 * @Description: TODO
 **/
public class Demo {
    public static void main(String[] args) {
        String a = new String("ab");//a为一个引用
        String b = new String("ab");//b为另一个引用，对象的内容一样
        String aa = "ab";//放在常量池中
        String bb = "ab";//从常量池中查找
        if (aa == bb)
            System.out.println("aa==bb");
        if (a == b)
            System.out.println("a==b");
        if (a.equals(b))
            System.out.println("aEQb");
        if (42 == 42.0 )
            System.out.println("true");
    }
}
