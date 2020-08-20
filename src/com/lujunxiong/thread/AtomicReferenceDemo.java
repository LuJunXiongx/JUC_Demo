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
 **/
class User{
    private String userName;
    private int age;

}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
//        User zs = new User("z3",22);
//        User ls = new User("ls", 22);
//        AtomicReference<User> userAtomicReference = new AtomicReference<>();
//        userAtomicReference.set(zs);
//        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());
//        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get().toString());

    }
}
