package com.abyss;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class test02 {
    public void test01(Map<String,student> map, List<student> list){
        System.out.println("test01");
    }
    public Map<String,student> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method01 = test02.class.getMethod("test01", Map.class, List.class);
        Type[] genericParameterTypes = method01.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("###############"+genericParameterType);
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        System.out.println("");
        Method method = test02.class.getMethod("test02", null);
        Type genericReturnType = method.getGenericReturnType();
        System.out.println(genericReturnType);
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
