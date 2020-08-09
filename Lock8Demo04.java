package com.fy.juc;

import java.util.concurrent.TimeUnit;

/*
 * 8锁就是有关锁的8个问题
 *
 *
 *4、两个对象，两个同步方法， 先发短信还是打电话？先打电话在发短信，因为有两把锁，则按时间来
 *
 * */
public class Lock8Demo04 {
    public static void main(String[] args) {
        Phone04 phone1=new Phone04();
        Phone04 phone2=new Phone04();
        new Thread(()->{
            phone1.sendSms();

        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();

        },"B").start();

    }


}

class Phone04{

    public synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }

    //这里没有锁 不是同步方法，不受锁的影响
    public void hello(){
        System.out.println("hello");
    }

}
