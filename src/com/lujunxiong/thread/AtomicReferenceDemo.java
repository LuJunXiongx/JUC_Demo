package com.lujunxiong.thread;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @ClassName AtomicReferenceDemo
 * @Author 陆军雄
 * @Date 2020/8/20
 * @Description: CAS缺点：循环时间长开销很大；只能保证一个共享变量的原子性；会引出ABA问题
 * ABA：狸猫换太子
 * 原子对象类型
 **/

class User{
    private String userName;
    private int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs = new User("zs",22);
        User ls = new User("ls", 25);
        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(zs);
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());

    }
}
