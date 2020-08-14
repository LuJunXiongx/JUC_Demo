package com.lujunxiong.thread;

/**
 * @ClassName LambdaExpressDemo
 * @Author 陆军雄
 * @Date 2020/8/12
 * @Description: Lambda表达式  口诀:拷贝小括号，写死右箭头，落地大括号
 * 函数式接口  @FunctionalInterface
 *
 * 接口里面可不可以有方法的实现，JDK8后可以
 *
 * default
 **/

@FunctionalInterface
interface Foo {
    public int add(int x, int y);
    default int div(int x ,int y){
        System.out.println("sfsafa45");
        return x/y;
    }

}

public class LambdaExpressDemo {
    public static void main(String[] args) {
       /* Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("hello+java");
            }
        };
        foo.sayHello();*/

        Foo foo = (int x, int y) -> {
            System.out.println("hello java lambda   111 11");
            return x + y;
        };
        System.out.println(foo.add(3, 8));
        System.out.println(foo.div(10,2));
    }
}
