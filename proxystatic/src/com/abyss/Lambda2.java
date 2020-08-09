package com.abyss;

public class Lambda2 {
    public static void main(String[] args) {
        iLove love=(int a)->System.out.println("i love you-->"+a);
        love.love(2);
    }
}
interface iLove{
    void love(int a);
}
class Love implements iLove{
    @Override
    public void love(int a) {
        System.out.println("i love you-->"+a);
    }
}