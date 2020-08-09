package com.fy.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //new Thread().start();

        MyThread thread=new MyThread();
        //适配器
        FutureTask futureTask = new FutureTask(thread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();//只会出现一个call()，因为结果会被缓存，效率高
        Integer o = (Integer) futureTask.get();
        System.out.println(o);

    }

}
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}