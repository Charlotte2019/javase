package com.abyss;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.print.attribute.standard.RequestingUserName;
import java.awt.*;

public class TestPC {
    public static void main(String[] args) {
        SynContainer Container = new SynContainer();
        new Producer(Container).start();
        new Consumer(Container).start();
    }
}
class Producer extends Thread{
    SynContainer container;
    public Producer(SynContainer synContainer){
        this.container=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread{
    SynContainer container;
    public Consumer(SynContainer synContainer){
        this.container=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+container.pop().id+"只鸡");
        }
    }
}

class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

class SynContainer{
    Chicken[] chickens=new Chicken[10];
    int count=0;

    public synchronized void push(Chicken chicken){
        if (count==chickens.length){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count++]=chicken;
        this.notifyAll();
    }

    public synchronized Chicken pop(){
        if (count==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return chickens[--count];
    }
}










