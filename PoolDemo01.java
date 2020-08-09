package com.fy.juc;

import java.util.concurrent.*;

public class PoolDemo01 {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool =Executors.newFixedThreadPool(5);
        //ExecutorService threadPool =Executors.newCachedThreadPool();
        /*
        * 最大线程如何定义？
        * 1、CPU密集型：电脑几核就是几，保持CPU效率最高
        * 获取CPU核数：
        * Runtime.getRuntime().availableProcessors()
        *
        * 2、IO密集型：大于程序中十分耗IO的线程
        *
        * */

        ExecutorService threadPool =new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );



        try {
            for (int i = 0; i <8 ; i++) {
                //用线程池来创建线程
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }


    }
}
