package com.fy.juc;


import java.util.function.Consumer;

/*
* 消费型接口：只有输入，没有返回值
*
* */
public class FuncDemo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);

            }
        };

        consumer.accept("aaaaddef");

        Consumer<String> consumer1=(s)->{
            System.out.println(s);
        };
        consumer1.accept("sdsdfsdf");
    }

}
