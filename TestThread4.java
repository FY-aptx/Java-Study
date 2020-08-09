package com.fy.thread;


//发现问题，多个线程操纵一个资源
public class TestThread4 implements Runnable{
    private int ticketnums=10;
    @Override
    public void run() {
        while(true){
            if (ticketnums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+ticketnums--+"票");

        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4=new TestThread4();
        new Thread(testThread4,"小明").start();
        new Thread(testThread4,"老师").start();
        new Thread(testThread4,"黄牛").start();


    }
}
