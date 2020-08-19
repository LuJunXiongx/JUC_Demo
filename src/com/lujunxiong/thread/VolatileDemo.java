package com.lujunxiong.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName VolatileDemo
 * @Author 陆军雄
 * @Date 2020/8/19
 * @Description: volatile是Java虚拟机提供的轻量级的同步机制
 * 保证可见性：某个线程修改完自己工作空间的值，并写回给主内存，要及时通知其他线程，其他线程可以知道这个值。
 * 不保证原子性
 * 禁止指令重排
 **/
class MyData {
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }
    public   void addPlusPlus(){
        number++;
    }
    AtomicInteger atomicInteger =new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }


}

/**
 * 1.验证可见性
 *   假如int number = 0，number变量之前根本没有添加volatile关键字修饰，没有可见性
 * 2.验证volatile不保证原子性
 *   原子性：不可分割，完整性，也即某个线程正在某个具体业务时，中间不可以被加塞或者分割。需要整体完整，要么同时成功，要么同时失败。
 *   如何解决原子性：加synchronized；使用juc下的AtomicInteger
 *   AtomicInteger的原理：
 *
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {
        //seeOkByVolatile();
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(()->{
                for(int j = 1; j<=1000;j++){
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少
        //加synchronized才能得出20000
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t 不加原子类型的Integer最后的值为：" + myData.number);
        System.out.println(Thread.currentThread().getName()+"\t 加原子类型的Integer最后的值为：" + myData.atomicInteger);


    }

    /**
     * 验证可见性代码，volatile可以保证可见性，及时通知其他线程，主内存的值已经被修改
     */
    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            //暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update to " + myData.number);
        }, "AAA").start();

        //第2个线程就是我们的main线程
        while (myData.number == 0) {
            //main线程就一直在这里等待循环，直至number值不再等于0；
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over，main get number value: "+myData.number);
    }
}
