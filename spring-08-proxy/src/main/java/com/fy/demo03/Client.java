package com.fy.demo03;


public class Client {

    public static void main(String[] args) {
        //真实角色
        Host host=new Host();
        //代理角色:目前只有处理程序，需要用处理程序生成代理类
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理要调用的接口对象
        pih.setRent(host);

        Rent proxy= (Rent) pih.getProxy();
        proxy.rent();

    }
}
