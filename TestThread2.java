package com.fy.thread;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;//网络图片地址
    private String name;//保存的文件名

    public TestThread2(String url,String name){
        this.url=url;
        this.name=name;

    }

    @Override
    public void run() {
        WebDownLoader webdownloader=new WebDownLoader();
        webdownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args){
        TestThread2 t1=new TestThread2("https://csdnimg.cn/medal/qixiebiaobing2@120.png","p1.png");
        TestThread2 t2=new TestThread2("https://csdnimg.cn/medal/qixiebiaobing2@120.png","p2.png");
        TestThread2 t3=new TestThread2("https://csdnimg.cn/medal/qixiebiaobing2@120.png","p3.png");
        t1.start();
        t2.start();
        t3.start();

    }
}

//下载器
class WebDownLoader{
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
