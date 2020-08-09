package com.abyss.syn;

import javafx.scene.control.cell.ChoiceBoxListCell;

import java.lang.reflect.ParameterizedType;

public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"A");
        Makeup g2 = new Makeup(1,"B");

        g1.start();
        g2.start();

    }
}

class Lipstick{

}
class Mirror{

}
class Makeup extends Thread{

    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();

    int choice;
    String girlName;

    public Makeup(int choice,String girlName){
        this.choice= choice;
        this.girlName=girlName;
    }

    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipstick){
                System.out.println(this.girlName+"口红");
                Thread.sleep(1000);
            }synchronized (mirror){
                System.out.println(this.girlName+"镜子");
            }
        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"镜子");
                Thread.sleep(2000);
            }
            synchronized (lipstick){
                System.out.println(this.girlName+"口红");
            }
        }
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
