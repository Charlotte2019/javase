package com.abyss.demo02;

import com.abyss.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.name=name;
        this.url=url;
    }

    @Override
    public Boolean call(){
        PictureDownLoad pictureDownLoad = new PictureDownLoad();
        pictureDownLoad.DownLoad(url,name);
        System.out.println("下载的文件名"+name);  
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("http://tiebapic.baidu.com/forum/w%3D580/sign=90e4708f2e01213fcf334ed464e636f8/7e158a82b9014a90ebf702ebbe773912b21bee99.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("http://tiebapic.baidu.com/forum/w%3D580/sign=170091988e25bc312b5d01906ede8de7/2c0a6e061d950a7b38fd0a921dd162d9f3d3c99a.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("http://tiebapic.baidu.com/forum/w%3D580/sign=616746ce49df8db1bc2e7c6c3923dddb/620a7bf40ad162d9cfd4254a06dfa9ec8a13cdb4.jpg", "3.jpg");
        TestCallable t4 = new TestCallable("http://tiebapic.baidu.com/forum/w%3D580/sign=4a30af32414e9258a63486e6ac82d1d1/71dda9ec8a13632721c38565868fa0ec08fac7b8.jpg", "4.jpg");
        ExecutorService ser = Executors.newFixedThreadPool(4);
        Future<Boolean> r1=  ser.submit(t1);
        Future<Boolean> r2=  ser.submit(t2);
        Future<Boolean> r3=  ser.submit(t3);
        Future<Boolean> r4=  ser.submit(t4);
        boolean rs1=r1.get();
        boolean rs2=r2.get();
        boolean rs3=r3.get();
        boolean rs4=r4.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        System.out.println(rs4);
        ser.shutdown();
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
