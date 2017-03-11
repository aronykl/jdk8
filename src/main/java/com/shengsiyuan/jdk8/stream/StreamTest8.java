package com.shengsiyuan.jdk8.stream;

import java.util.stream.IntStream;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 17:10
 */
public class StreamTest8 {
    public static void main(String[] args) {
        IntStream.iterate(0, item -> (item + 1) % 2).limit(6).distinct().forEach(System.out::println);
    }
}
