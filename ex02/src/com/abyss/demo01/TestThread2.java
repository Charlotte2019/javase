package com.abyss.demo01;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread {
    private String url;
    private String name;
    public TestThread2(String url,String name){
        this.name=name;
        this.url=url;
    }

    @Override
    public void run() {
        PictureDownLoad pictureDownLoad = new PictureDownLoad();
        pictureDownLoad.DownLoad(url,name);
        System.out.println("文件"+name+"下载完成");
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=90e4708f2e01213fcf334ed464e636f8/7e158a82b9014a90ebf702ebbe773912b21bee99.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=170091988e25bc312b5d01906ede8de7/2c0a6e061d950a7b38fd0a921dd162d9f3d3c99a.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=616746ce49df8db1bc2e7c6c3923dddb/620a7bf40ad162d9cfd4254a06dfa9ec8a13cdb4.jpg", "3.jpg");
        TestThread2 t4 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=4a30af32414e9258a63486e6ac82d1d1/71dda9ec8a13632721c38565868fa0ec08fac7b8.jpg", "4.jpg");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class PictureDownLoad{
    public void DownLoad(String url,String name) {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

