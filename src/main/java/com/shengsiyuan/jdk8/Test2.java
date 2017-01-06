package com.shengsiyuan.jdk8;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2016/12/19 23:24
 */
@FunctionalInterface
interface MyInterface {
    void test();

    String toString();
}

public class Test2 {
    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
//        test2.myTest(new MyInterface() {
//            @Override
//            public void test() {
//                System.out.println("My test!");
//            }
//        });
        test2.myTest(() -> {
            System.out.println("My test!");
        });

        System.out.println("--------------------");

        MyInterface myInterface = () -> {
            System.out.println("hello!");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}