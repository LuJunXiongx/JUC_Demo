package com.lujunxiong.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @ClassName Demo1
 * @Author 陆军雄
 * @Date 2020/7/27
 * @Description: 获取用键盘输入常用的两种方法
 **/
public class Demo1 {
    public static void main(String[] args) {
        //1.通过Scanner
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        //input.close();
        System.out.println(s);

        //2.通过BufferedReader
        BufferedReader i = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s1 = i.readLine();
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
