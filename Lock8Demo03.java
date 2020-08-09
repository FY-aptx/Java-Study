package com.fy.juc;

import java.util.concurrent.TimeUnit;

/*
 * 8锁就是有关锁的8个问题
 *
 *3、增加了一个普通方法后，是执行普通方法还是发短信？普通方法，因为没有锁
 *
 *
 * */
public class Lock8Demo03 {
    public static void main(String[] args) {
        Phone03 phone=new Phone03();

        new Thread(()->{
            phone.sendSms();

        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.hello();

        },"B").start();

    }


}

class Phone03{

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
