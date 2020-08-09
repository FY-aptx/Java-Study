package com.fy.juc;

import java.util.concurrent.TimeUnit;

/*
 * 8锁就是有关锁的8个问题
 *
 *5、增加两个静态同步方法后，是打电话还是发短信？
 *6、还是两个静态同步方法，就算创两个对象，仍然还是只有一个class模板，所得是class
 *
 * */
public class Lock8Demo05 {
    public static void main(String[] args) {
        //Phone05 phone=new Phone05();

        new Thread(()->{
            Phone05.sendSms();

        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            Phone05.call();

        },"B").start();

    }


}


//Phone05只有唯一的一个class对象
class Phone05{

    //static 静态方法，类一加载就有了，所的是class对象
    public static synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call(){
        System.out.println("打电话");
    }


}
