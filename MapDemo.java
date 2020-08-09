package com.fy.juc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MapDemo {
    public static void main(String[] args) {
        /*
         * 并发下HashMap不安全
         * Map<String,String> map=new HashMap<>();
         *解决方案：
         *1、 Map<String,String> map= Collections.synchronizedMap(new HashMap<>());
         *2、 Map<String,String> map=new ConcurrentHashMap<>();
         *
         *
         * */
        Map<String,String> map=new ConcurrentHashMap<>();



        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);

            },String.valueOf(i)).start();
        }

    }


}
