package com.fy.pojo;

public class UserTwo {
    private String name;



    public UserTwo(String name){
        this.name=name;
        System.out.println("User2的有参构造！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+name);
    }
}
