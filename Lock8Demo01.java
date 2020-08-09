package com.fy.juc;

import java.util.concurrent.TimeUnit;


/*
* 8锁就是有关锁的8个问题
* 1、标准情况下，两个线程先打印  发短信还是打电话？ 先发短信再打电话
*
*
* */
public class Lock8Demo01 {

    public static void main(String[] args) {
        Phone phone=new Phone();
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

class Phone{
    public synchronized  void sendSms(){
        System.out.println("发短信");
    }

    public synchronized  void call(){
        System.out.println("打电话");
    }


}