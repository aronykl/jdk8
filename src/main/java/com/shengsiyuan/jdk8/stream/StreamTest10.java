package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/7 20:44
 */
public class StreamTest10 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello1", "world1", "hello world");

//        list.stream().mapToInt(item -> item.length()).filter(length -> length == 5)
//                .findFirst().ifPresent(System.out::println);

        list.stream().mapToInt(item -> {
            int length = item.length();
            System.out.println(item);
            return length;
        }).filter(length -> length == 5).findFirst().ifPresent(System.out::println);
    }
}
