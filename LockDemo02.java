package com.fy.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo02 {
    public static void main(String[] args) {
        Phonex2 phonex=new Phonex2();
        new Thread(()->{
            phonex.sms();
        },"A").start();

        new Thread(()->{
            phonex.sms();
        },"B").start();
    }

}

class Phonex2{
    Lock lock=new ReentrantLock();
    //用lock，锁要配对
    public void sms(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"sms");
            call();//这里也有锁

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void call(){
        lock.lock();
        try {
        System.out.println(Thread.currentThread().getName()+"call");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
