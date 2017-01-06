package com.shengsiyuan.jdk8;

import java.util.function.Supplier;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/7 00:58
 */
public class StudentTest {

    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        System.out.println("---------------------------");

        Supplier<Student> supplier1 = Student::new;
        System.out.println(supplier1.get().getName());
    }
}
