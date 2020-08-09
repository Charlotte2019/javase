package com.abyss;

public class TestSleep implements Runnable {
    private int tickets=10;
    @Override
    public void run() {
        while (true){
            if (tickets<=0){
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+tickets--+"票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep,"工作人员").start();
        new Thread(testSleep,"顾客").start();
        new Thread(testSleep,"黄牛").start();
    }
}
