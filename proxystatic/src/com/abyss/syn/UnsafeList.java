package com.abyss.syn;

import java.util.ArrayList;
import java.util.List;

public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            synchronized (list){
                new Thread(()->list.add(Thread.currentThread().getName())).start();
            }
        }
        System.out.println(list.size());
    }
}
