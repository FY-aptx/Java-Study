package com.fy.juc;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetDemo {

    public static void main(String[] args) {
        /*
        * 并发下Set不安全
        * Set<String> set=new HashSet<>();
        *解决方案：
        *1、Set<String> set= Collections.synchronizedList(new HashSet<>());
        *2、Set<String> set=new CopyOnWriteArraySet<>();
        *
        *
        * */
        Set<String> set=new CopyOnWriteArraySet<>();

        for (int i = 0; i <30 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);

            },String.valueOf(i)).start();

        }



    }

}
