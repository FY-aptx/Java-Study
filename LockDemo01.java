package com.fy.juc;

public class LockDemo01 {
    public static void main(String[] args) {
        Phonex phonex=new Phonex();
        new Thread(()->{
            phonex.sms();
        },"A").start();

        new Thread(()->{
            phonex.sms();
        },"B").start();
    }

}

class Phonex{
    public synchronized void sms(){
        System.out.println(Thread.currentThread().getName()+"sms");
        call();
    }

    public synchronized void call(){
        System.out.println(Thread.currentThread().getName()+"call");
    }

}
