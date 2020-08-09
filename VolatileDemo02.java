package com.fy.juc;

import java.util.concurrent.atomic.AtomicInteger;

/*
* volatile不保证原子性
* 解决方法：
* 加锁，或者AtomicInteger
* */
public class VolatileDemo02 {
    //private volatile static int num=0;
    private volatile static AtomicInteger num=new AtomicInteger();
    public static void add(){
        //num++;不是原子操作
        num.getAndIncrement();
    }

    public static void main(String[] args) {
        /*
        * 理论上结果应该是2万
        * 但结果是小于2万的，说明volatile不保证原子性
        * */
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }

            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);

    }


}
