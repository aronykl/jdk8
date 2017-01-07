package com.shengsiyuan.jdk8;

import java.util.Optional;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/7 12:58
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        optional.ifPresent(value -> System.out.println(value));
    }
}
