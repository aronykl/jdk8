package com.shengsiyuan.jdk8.defaultmethod;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/4 20:51
 */
public interface MyInterface2 {
    default void myMethod() {
        System.out.println("MyInterface2");
    }
}
