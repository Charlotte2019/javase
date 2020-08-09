package com.abyss;
//礼让
public class TestYield implements Runnable{
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
        new Thread(myYield,"c").start();
    }
}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
}
