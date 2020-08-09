package com.fy.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        test4();

    }
    /*
    * 抛出异常
    *
    * */
    public static void test1(){
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        /*
        * IllegalStateException: Queue full
        *若再执行 System.out.println(blockingQueue.add("d"));
        * */
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());


        /*
        *NoSuchElementException
        *若再执行 System.out.println(blockingQueue.remove());
        * */

    }

    public static void test2(){
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //超过大小不会报错，而是false
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        //队列中没有了值，不会报错，而是取得null
        System.out.println(blockingQueue.poll());
    }

    public static void test3() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        /*
        * 队列已满，一直阻塞
        * blockingQueue.put("d");
        * */


        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        /*
        *没有元素了，一直等待
        * System.out.println(blockingQueue.take());
        * */
    }

    public static void test4() throws InterruptedException {
        //队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");

        //等待两秒再报false
        blockingQueue.offer("d",2, TimeUnit.SECONDS);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        //没有值了，等待两秒再报false
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));

    }

}
