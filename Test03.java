package com.fy.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    //注解可以显示赋值，如果没有默认值，必须给注解赋值
    @MyAnnotation2(name="FY")
    public void test(){

    }

    @MyAnnotation3("FY")
    public void test2(){

    }

}


@Target(value ={ElementType.METHOD,ElementType.TYPE} )
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation2{

    //注解的参数：参数类型+参数名();
    String name() default "";
    int age() default 0;
    int id() default -1;//如果默认值为-1，代表不存在
    String[] schools() default {"西南大学","清华大学"};
}

@Target(value ={ElementType.METHOD,ElementType.TYPE} )
@Retention(value = RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();//当一个参数建议使用value，在使用注解时，value可以省略

}