package com.fy.annotation;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    //@Override重写
    @Override
    public String toString() {
        return super.toString();
    }

    //Deprecated不推荐使用，但是可以使用，或者存在更好地方式
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    @SuppressWarnings("all")
    public void test02(){
        List list=new ArrayList();
    }

    public static void main(String[] args) {
        test();
    }
}
