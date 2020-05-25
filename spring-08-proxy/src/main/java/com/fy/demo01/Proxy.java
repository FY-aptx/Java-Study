package com.fy.demo01;

public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        host.rent();
        seeHose();
        sign();
        fare();
    }

    //看房
    public void seeHose(){
        System.out.println("中介带人看房");
    }

    //签合同
    public void sign(){
        System.out.println("签租赁合同");
    }

    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
