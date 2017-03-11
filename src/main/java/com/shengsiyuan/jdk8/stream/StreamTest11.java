package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/7 20:54
 */
public class StreamTest11 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello welcome", "world hello",
                "hello world hello", "hello welcome");

//        list.stream().map(item -> {
//            String[] stringArray = item.split(" ");
//            List<String> stringList = Arrays.asList(stringArray);
//            return stringList;
//        }).flatMap(list1 -> list1.stream()).collect(Collectors.toSet()).forEach(System.out::println);

//        list.stream().map(item -> {
//            String[] stringArray = item.split(" ");
//            List<String> stringList = Arrays.asList(stringArray);
//            return stringList;
//        }).flatMap(list1 -> list1.stream()).distinct().forEach(System.out::println);

//        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream)
//                .distinct().forEach(System.out::println);

        list.stream().flatMap(item -> Arrays.asList(item.split(" ")).stream()).distinct().forEach(System.out::println);
    }
}
