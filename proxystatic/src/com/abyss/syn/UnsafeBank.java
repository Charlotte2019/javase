package com.abyss.syn;

import java.awt.image.PackedColorModel;

public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000000,"基金");
        Drawing me = new Drawing(account,1000000,"me");
        Drawing you = new Drawing(account,50000,"you ");
        me.start();
        you.start();
    }
}
class Account{
    private int money;
    private String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Drawing extends Thread {
    private Account account;
    private int drawingMoney;
    private int nowMoney;

    public Drawing(Account account,int drawingMoney,String name){
        this.account=account;
        this.drawingMoney=drawingMoney;
        super.setName(name);
    }

    @Override
    public void run() {
        if (account.getMoney()-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"余额不足");
            return;
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        account.setMoney(account.getMoney()-drawingMoney);
        System.out.println(account.getName()+"账号余额"+account.getMoney());
        System.out.println(this.getName()+"手里的钱"+drawingMoney);

    }
}