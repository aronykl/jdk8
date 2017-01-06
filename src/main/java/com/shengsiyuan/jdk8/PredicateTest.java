package com.shengsiyuan.jdk8;

import java.util.function.Predicate;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/6 18:28
 */
public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.length() > 5;
        System.out.println(predicate.test("Hello1"));

        System.out.println(Predicate.isEqual(null).test(null));
    }
}
