package com.fy.juc;

import java.util.concurrent.TimeUnit;

/*
 * 8锁就是有关锁的8个问题
 *
 *2、SendSms延迟4秒，两个线程先打印  发短信还是打电话？先发短信再打电话
 *syschronized锁的对象是方法的调用者
 * 两个方法用的同一个锁，谁先拿到谁先执行
 *
 *
 * */
public class Lock8Demo02 {
    public static void main(String[] args) {
        Phone02 phone=new Phone02();
        new Thread(()->{
            phone.sendSms();

        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();

        },"B").start();

    }


}

class Phone02{

    public synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized  void call(){
        System.out.println("打电话");
    }

}
