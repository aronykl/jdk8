package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的创建
 * @Author: zhouwen
 * @Date: 2017/2/5 10:33
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Stream stream1 = Stream.of("hello", "world", "hello world");

        String[] myArray = new String[] {"hello", "world", "hello world"};
        Stream stream2 = Stream.of(myArray);

        Stream stream3 = Arrays.stream(myArray);

        List<String> list = Arrays.asList(myArray);
        Stream stream4 = list.stream();

    }
}
