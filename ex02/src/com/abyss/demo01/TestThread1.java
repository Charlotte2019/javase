package com.abyss.demo01;

public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("AAA---"+i);
        }
    }

    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1();
        testThread1.start();
        testThread1.run();

        for (int i = 0; i < 10; i++) {
            System.out.println("QQQ---"+i);
        }
    }
}
