package com.abyss.syn;

import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        TestLock2 lock1 = new TestLock2();
        TestLock2 lock2 = new TestLock2();
        TestLock2 lock3 = new TestLock2();

        new Thread(lock1).start();
        new Thread(lock1).start();
        new Thread(lock1) .start();
    }

}
class TestLock2 implements Runnable{

    int ticketNums=10;

    private final ReentrantLock lock=new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();
                if (ticketNums>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }
        }
    }
}