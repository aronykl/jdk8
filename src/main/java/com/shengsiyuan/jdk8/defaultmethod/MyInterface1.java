package com.shengsiyuan.jdk8.defaultmethod;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/4 20:50
 */
public interface MyInterface1 {

    default void myMethod() {
        System.out.println("MyInterface1");
    }
}
