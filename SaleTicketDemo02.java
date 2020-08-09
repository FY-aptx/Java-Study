package com.fy.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        //并发：多个线程操作同一个资源类，把资源类丢入线程
        Ticket02 ticket=new Ticket02();

        //@FunctionInterface函数式接口 jdk1.8 lambda表达式 (参数)->{代码}

        new Thread(()->{for (int i = 0; i < 40; i++) {ticket.sale(); }},"A").start();
        new Thread(()->{for (int i = 0; i < 40; i++) {ticket.sale(); }},"B").start();
        new Thread(()->{for (int i = 0; i < 40; i++) {ticket.sale(); }},"C").start();

    }

}

//lock
class Ticket02{
    //属性，方法
    private int number=30;
    Lock lock=new ReentrantLock();

    //买票的方式
    public void sale(){

        lock.lock();//加锁
        try{
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余："+number);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

}
