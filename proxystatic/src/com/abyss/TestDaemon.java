package com.abyss;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
//守护
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();;
    }
}

class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑");
        }
    }
}

class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("alive");
        }
        System.out.println("goodbye world!");
    }
}