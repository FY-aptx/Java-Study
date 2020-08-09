package com.fy.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
* 异步调用
* 1、异步执行
* 2、成功回调
* 3、失败回调
* */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //发起一个请求
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()-> {

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
        });

        System.out.println("1111");
        //获取阻塞执行结果
        completableFuture.get();

        //有返回值 supplyAsync
        CompletableFuture<Integer> completableFuture2=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"supplyAsync=>Integer");
            return 1024;
        });

        System.out.println(completableFuture2.whenComplete((t, u) -> {
            System.out.println("t=>" + t);//正常的返回结果
            System.out.println("u=>" + u);

        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;
        }).get());

    }
}
