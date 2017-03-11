package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 16:52
 */
public class StreamTest7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld");
//        list.stream().map(item -> item.substring(0, 1).toUpperCase() + item.substring(1))
//                .forEach(System.out::println);

        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        }).forEach(System.out::println);
    }
}
