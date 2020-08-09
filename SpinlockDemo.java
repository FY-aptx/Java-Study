package com.fy.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinlockDemo {

    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    //加锁
    public void mylock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==> mylock");

        //自旋锁
        while(atomicReference.compareAndSet(null,thread)){

        }
    }

    //解锁
    public void myUnlock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==> myUnlock");
        atomicReference.compareAndSet(thread,null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinlockDemo lock = new SpinlockDemo();
        lock.mylock();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }

        },"T1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnlock();
            }

        },"T2").start();




    }


}
