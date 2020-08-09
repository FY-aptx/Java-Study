package com.fy.demo04;


import com.fy.demo03.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//要用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //生成得到的代理类

    /**
     * newProxyInstance参数
     loader: 用哪个类加载器去加载代理对象
     interfaces:动态代理类需要实现的接口
     h:动态代理方法在执行时，会调用h里面的invoke方法去执行**/
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    //处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的机制就是使用反射机制实现的
        log(method.getName());

        Object result = method.invoke(target, args);

        return result;
    }
    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }


}
