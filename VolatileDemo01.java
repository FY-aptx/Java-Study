package com.fy.juc;

import java.util.concurrent.TimeUnit;
/*
* volatile保证可加性
*
* */
public class VolatileDemo01 {
    private volatile static int num=0;
    public static void main(String[] args) {
        new Thread(()->{
            //该线程不可见主内存的变化，会一直循环，要解决，可加volatile关键字
            while (num==0){

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num=1;
        System.out.println(num);
    }

}
