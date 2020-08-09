package com.fy.demo03;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//要用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {
    /**
     * newProxyInstance参数
     loader: 用哪个类加载器去加载代理对象
    interfaces:动态代理类需要实现的接口
    h:动态代理方法在执行时，会调用h里面的invoke方法去执行**/
    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);
    }

    //处理代理实例，并返回结果

    /*
    * invoke三个参数：
      proxy：就是代理对象，newProxyInstance方法的返回对象
      method：调用的方法
      args: 方法中的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //动态代理的机制就是使用反射机制实现的
        seeHouse();
        //method.invoke(" 要调用的方法的名字所隶属的对象实体",方法的参数值);
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }

    public void seeHouse(){
        System.out.println("中介带看房子");
    }

    public void fare(){
        System.out.println("收中介费");
    }
}
