package com.fy.juc;

import java.util.function.Function;

/*
* 1、函数型接口
*只要是函数型接口，可以用lambda表达式
* */
public class FuncDemo01 {
    public static void main(String[] args) {
       Function function=new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        System.out.println(function.apply("FY"));

        Function function1=(str)->{return str;};
        System.out.println(function1.apply("FYER"));


    }

}
