package com.fy.thread;

//创建线程方式一：继承Thread类，重写run方法，调用start开启线程
//注意线程开启不一定立即执行，由cpu调度执行

public class TestTheard1 extends Thread{
    @Override
    public void run() {
        //run 方法线程体
        for (int i=0;i<20;i++){
            System.out.println("我在看代码---"+i);

        }
    }
    public static void main(String[] args) {
            TestTheard1 testTheard1=new TestTheard1();
            testTheard1.start();

            for (int i=0;i<20;i++){
                System.out.println("我在学习多线程---"+i);
            }
            //main线程，主线程
        }

}
