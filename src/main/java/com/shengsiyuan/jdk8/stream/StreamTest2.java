package com.shengsiyuan.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 10:41
 */
public class StreamTest2 {

    public static void main(String[] args) {
        IntStream.of(new int[] {5, 6, 7}).forEach(System.out::println);

        System.out.println("-------------------");

        IntStream.range(3, 8).forEach(System.out::println);

        System.out.println("-------------------");

        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}
