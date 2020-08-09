package com.abyss.syn;

public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"A").start();
        new Thread(buyTicket,"B").start();
        new Thread(buyTicket,"C").start();
    }
}
class BuyTicket implements Runnable{
    private int ticketNums =10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            buy();
        }
    }

    //synchronized 同步 锁 this
    private synchronized void buy() {
        if (ticketNums<=0){
            flag=false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"获得第"+ticketNums--+"张票");
    }

}