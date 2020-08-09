package com.fy.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//通过反射，动态的创建对象
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.fy.reflection.User");

        //构造一个对象
        User user1 = (User)c1.newInstance();//本质是调用了类的无参构造器
        System.out.println(user1);

        //通过构造器创建对象
        Constructor declaredConstructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) declaredConstructor.newInstance("FY", 001, 1);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3=(User)c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3,"FY");//invoke()激活执行
        System.out.println(user3.getName());

        //通过反射操作属性，不能直接操作私有属性，需要关闭安全检测
        User user4=(User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);//取消安全检测
        name.set(user4,"FYER");
        System.out.println(user4.getName());

    }
}
