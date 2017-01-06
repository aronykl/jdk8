package com.shengsiyuan.jdk8;

import java.util.function.Supplier;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/7 00:46
 */
public class SupplierTest {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "Hello World!";
        System.out.println(stringSupplier.get());
    }
}
