package com.abyss;

public class Lambda {
    static class Like2 implements iLike{

        @Override
        public void lambda() {
            System.out.println("i like lambda2");
        }
    }
    public static void main(String[] args) {
        iLike like=new Like();
        like.lambda();

        like=new Like2();
        like.lambda();

        class Like3 implements iLike{
            @Override
            public void lambda() {
                System.out.println("i like lambda3");
            }
        }

        like=new Like3();
        like.lambda();


        like = new iLike() {
            @Override
            public void lambda() {
                System.out.println("i like lambda4");
            }
        };

        like.lambda();

        like=()-> System.out.println("i like lambda5");
        like.lambda();

    }
}

interface iLike{
    void lambda();
}
class Like implements iLike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}