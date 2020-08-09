package com.abyss;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestStop2 implements Runnable {
    @Override
    public void run() {

    }
    public static void TenDown() throws InterruptedException {
        int num=10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0){
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Date startTime=new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime=new Date(System.currentTimeMillis());
        }
    }
}
