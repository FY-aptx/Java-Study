package com.fy.juc;

import java.util.concurrent.TimeUnit;

/*
 * 8锁就是有关锁的8个问题
 *
 *7、一个静态的同步方法和一个普通的同步方法，是先打电话还是发短信？
 *8、创建两个对象，一个静态的同步方法和一个普通的同步方法，是先打电话还是发短信？
 *
 * */
public class Lock8Demo06 {
    public static void main(String[] args) {
        Phone06 phone=new Phone06();

        new Thread(()->{
            Phone06.sendSms();

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


//Phone05只有唯一的一个class对象
class Phone06{

    //static 静态方法，类一加载就有了，锁的是class对象
    public static synchronized  void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }



    //普通同步方法，锁的是调用者
    public synchronized void call(){
        System.out.println("打电话");
    }


}
