package com.fy.juc.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
* 懒汉式
* */
public class LazyMan {
    private LazyMan(){
        synchronized (LazyMan.class){
            if(lazyMan==null){
                throw new RuntimeException("不要试图使用反射破坏");
            }
        }

        System.out.println(Thread.currentThread().getName()+"ok");

    }
    private volatile static LazyMan lazyMan;

    //双重检测锁模式，懒汉式单例，DCL
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    //不是原子性操作
                    lazyMan=new LazyMan();
                    /*
                    * 1、分配内存空间
                    * 2、执行构造方法，初始化对象
                    * 3、把这个对象指向这个空间
                    * */

                }
            }
        }
        return lazyMan;
    }
    
/*    //多线程并发
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }*/

    //反射
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyMan instance=LazyMan.getInstance();
        Constructor<LazyMan> declareConstructor=LazyMan.class.getDeclaredConstructor(null);
        declareConstructor.setAccessible(true);
        LazyMan instance2 = declareConstructor.newInstance();

        System.out.println(instance);
        System.out.println(instance2);
    }


}
