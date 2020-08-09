package com.fy.annotation;

import java.lang.annotation.*;

//测试元注解
public class Test02 {

    @MyAnnotation
    public void test(){

    }

}


//定义一个注解
//Target表示注解可以用在哪些地方
@Target(value ={ElementType.METHOD,ElementType.TYPE} )

//Retention表示注解在哪些地方才有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)

//Documented表示是否将我们的注解生成在JAVAdoc中
@Documented

//Inherited子类可以继承父类的注解
@Inherited
@interface MyAnnotation{

}
