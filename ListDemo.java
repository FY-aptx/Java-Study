package com.fy.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    public static void main(String[] args) {
        /*
        * 并发下ArrayList不安全
        * List<String> list=new ArrayList<>();
        *解决方案：
        *1、List<String> list=new Vector<>();
        *2、List<String> list= Collections.synchronizedList(new ArrayList<>());
        *3、List<String> list=new CopyOnWriteArrayList<>();
        * */
        /*
        * CopyOnWrite写时复制
        * */

        List<String> list=new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);

            },String.valueOf(i)).start();

        }
    }
}
