package com.fy.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获得类的信息
public class Test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.fy.reflection.User");

        User user=new User();
        c1=user.getClass();

        //获得类的名字
        System.out.println(c1.getName());//获得包名+类名
        System.out.println(c1.getSimpleName());//获得类名

        //获得类的属性
        System.out.println("============public属性=============");
        Field[] fields = c1.getFields();//只能找到public属性
        for (Field field : fields) {
            System.out.println(field);

        }
        System.out.println("============所有属性=============");
        fields=c1.getDeclaredFields();//可以找到所有属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得属性的值
        System.out.println("============指定属性=============");
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("============本类及其父类的所有public方法=============");
        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println(method);

        }
        methods=c1.getDeclaredMethods();
        System.out.println("===========本类的所有方法==============");
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("===========指定方法==============");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得构造器
        System.out.println("===========public构造器==============");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);

        }

        System.out.println("===========所有构造器==============");
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);

        }

        System.out.println("===========指定构造器==============");
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println(constructor);

    }
}
