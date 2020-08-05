package com.abyss;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class test01 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        Class<student> studentClass = student.class;
        /*System.out.println(studentClass.getName());
        System.out.println(studentClass.getSimpleName());
        Field[] fields = studentClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("=========================================");
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        System.out.println("========================================");
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("========================================");
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("========================================");
        Constructor[] constructors = studentClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("========================================");
        Constructor<student> declaredConstructor = studentClass.getDeclaredConstructor(String.class, int.class);
        System.out.println(declaredConstructor);*/


        /*Constructor<student> declaredConstructor = studentClass.getDeclaredConstructor(String.class, int.class, String.class);
        student student = declaredConstructor.newInstance("QAQ", 123, "AQA");
        System.out.println(student);

        student student1 = studentClass.newInstance();
        Method setName = studentClass.getMethod("setName", String.class);
        setName.invoke(student1,"QAQ");
        System.out.println(student1.getName());

        student student2 = studentClass.newInstance();
        Field name = studentClass.getDeclaredField("name");
        //打开
        name.setAccessible(true);
        name.set(student2,"QWER");
        System.out.println(student2.getName());*/

        test01();
        test02();
        test03();

    }

    public static void test01(){
        student student = new student();
        long startTime =System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            student.getName();
        }

        long endTime =System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        student student = new student();
        Class s1 = student.getClass();
        Method getName = s1.getDeclaredMethod("getName", null);

        long startTime =System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            getName.invoke(student,null);
        }

        long endTime =System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        student student = new student();
        Class s1 = student.getClass();
        Method getName = s1.getDeclaredMethod("getName", null);
        getName.setAccessible(true);
        long startTime =System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            getName.invoke(student,null);
        }

        long endTime =System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}

class student{
    private String name;
    private int id;
    public String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public student() {
    }

    public student(String name, int id, String sex) {
        this.name = name;
        this.id = id;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex='" + sex + '\'' +
                '}';
    }
}

