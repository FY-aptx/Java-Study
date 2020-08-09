package com.fy.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
* CAS存在的问题
* 1、循环消耗资源
* 2、只能保持一个共享变量的原子操作
* 3、ABA问题
*
* */
public class CASDemo {
    public static void main(String[] args) {
        //AtomicInteger atomicInteger=new AtomicInteger(2020);
        /*
        * 解决ABA问题，乐观锁，用带时间戳的原子引用 AtomicStampedReference
        * */
        /*
        *注意：如果泛型是一个包装类比如Integer，注意对象的引用问题
        * 正常业务操作，比较是都是对象
        * */
        AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(1,1);
        /*      System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());*/

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();//获得版本号
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 2,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("a2=>"+atomicStampedReference.getStamp());
            System.out.println(atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a3=>"+atomicStampedReference.getStamp());
        },"a").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();//获得版本号
            System.out.println("b1=>"+stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 6,
                    stamp, stamp + 1));
            System.out.println("b1=>"+atomicStampedReference.getStamp());
        },"b").start();


    }
}
