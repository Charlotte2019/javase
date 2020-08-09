package com.abyss;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new People());
        weddingCompany.happyMarry();
    }
}
interface Marry{
    void happyMarry();
}
class People implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("结婚很高兴");
    }
}

class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("清理场地");
    }

    private void before() {
        System.out.println("布置场地");
    }
}
