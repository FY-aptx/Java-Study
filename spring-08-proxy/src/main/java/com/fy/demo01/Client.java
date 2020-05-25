package com.fy.demo01;

public class Client {
    public static void main(String[] args) {
        Host host=new Host();
        //找房东
        //host.rent();
        //找(代理)中介，但中介一般会加一些附加操作
        Proxy proxy = new Proxy(host);
        //不用面对房东，直接找中介
        proxy.rent();
    }
}
