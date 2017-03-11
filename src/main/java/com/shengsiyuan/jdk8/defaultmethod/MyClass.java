package com.shengsiyuan.jdk8.defaultmethod;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/4 20:51
 */
public class MyClass extends MyInterfaceImpl implements MyInterface2 {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();
    }

//    @Override
//    public void myMethod() {
//        MyInterface1.super.myMethod();
//    }
}
