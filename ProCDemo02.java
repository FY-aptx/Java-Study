package com.fy.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProCDemo02 {
    public static void main(String[] args) {
        Data02 data=new Data02();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"A").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"B").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"C").start();

        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"D").start();
    }


}

//等待，业务，通知
class Data02{
    private int num=0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();
    /*
    * condition.await(); 等待
    * condition.signalAll(); 唤醒全部
    * */


    public void increment() throws InterruptedException {
        lock.lock();

        try {
            while(num!=0) {
                //等待
                condition.await();
            }
                num++;
                System.out.println(Thread.currentThread().getName() + "=>" + num);
                //通知其他线程，+1执行完毕
                condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public void decrement() throws InterruptedException {
        lock.lock();

        try {
            while (num == 0) {
                //等待
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "=>" + num);
            //通知其他线程，-1执行完毕
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}

