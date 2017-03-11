package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 14:35
 */
public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "helloworld", "test");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("---------------");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4);
        list2.stream().map(item -> item * item).forEach(System.out::println);

        System.out.println("---------------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6));
        stream.flatMap(theList -> theList.stream()).map(integer -> integer * integer)
                .forEach(System.out::println);
    }
}
