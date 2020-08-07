package com.abyss.demo01;

public class TestThread4 implements Runnable{
    private int ticketNums=100;


    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"张票");
            }
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket,"工作人员").start();
        new Thread(ticket,"用户").start();
        new Thread(ticket,"黄牛").start();
    }
}
