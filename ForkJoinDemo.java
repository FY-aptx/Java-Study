package com.fy.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/*
* 求和计算任务
* */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    //临界值
    private Long temp=1000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start=start;
        this.end=end;
    }

    //计算方法
    @Override
    protected Long compute() {
        if((end-start)<temp){
            Long sum=0L;
            for (Long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }
        else{//分支合并
            //中间值
            long middle=(start+end)/2;
            ForkJoinDemo task1=new ForkJoinDemo(start,middle);
            task1.fork();//拆分任务，把任务压入线程队列
            ForkJoinDemo task2=new ForkJoinDemo(middle+1,end);
            task2.fork();//拆分任务，把任务压入线程队列
            return task1.join()+task2.join();

        }

    }

    public static void test1(){
        Long sum=0L;
        long start=System.currentTimeMillis();
        for (Long i = 1L; i <=10_0000_0000 ; i++) {
            sum+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println("sum="+sum+"时间："+(end-start));

    }

    public static void test2() throws ExecutionException, InterruptedException {
        Long sum=0L;
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinDemo(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum2 = submit.get();
        long end=System.currentTimeMillis();
        System.out.println("sum="+sum2+"时间："+(end-start));

    }

    public static void test3(){
        long start=System.currentTimeMillis();
        //Stream并行流
        long sum3 = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        long end=System.currentTimeMillis();
        System.out.println("sum="+sum3+"时间："+(end-start));

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test3();

    }
}
