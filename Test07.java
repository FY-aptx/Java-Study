package com.fy.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器-->应用类加载器（AppClassLoader）
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类的父类加载器-->扩展类加载器（ExtClassLoader）
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器（无法直接获取）
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类时哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.fy.reflection.Test07").getClassLoader();
        System.out.println(classLoader);


        //测试JDK内置的类是哪个加载器加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获取系统类加载器可以加载的路径

        String property = System.getProperty("java.class.path");
        System.out.println(property);


    }

}
