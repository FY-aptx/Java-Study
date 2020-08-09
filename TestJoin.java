package com.fy.thread;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("线程VIP来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        TestJoin testJoin=new TestJoin();
        Thread thread=new Thread(testJoin);
        thread.start();

        for (int i=0;i<500;i++){
            if(i==200){
                thread.join();
            }
            System.out.println("main"+i);
        }





    }
}
