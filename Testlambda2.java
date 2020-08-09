package com.fy.thread;

public class Testlambda2 {
    //
    static class Love implements ILove{
        @Override
        public void love(int a) {
            System.out.println("I love you-->"+a);
        }
    }

    public static void main(String[] args) {
        ILove love=new Love();
        love.love(2);

        ILove love2=(int a)->{
            System.out.println("I love you-->"+a);
        };

        //简化括号和参数类型，适用于多行代码
        love2=a->{
            System.out.println("I love you-->"+a);
        };

        //简化花括号，适用于一行代码
        love2=a->System.out.println("I love you-->"+a);


        love2.love(520);
    }



}

interface ILove{
    void love(int a);
}
//
class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("I love you-->"+a);
    }
}