package com.shengsiyuan.jdk8.stream2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/3/11 19:43
 */
public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");

//        Collections.sort(list, Comparator.comparingInt(String::length).reversed());
//        Collections.sort(list, Comparator.comparingInt((String item) -> item.length()).reversed());

//        list.sort(Comparator.comparingInt(String::length).reversed());
//        list.sort(Comparator.comparingInt((String item) -> item.length()).reversed());

//        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));

//        Collections.sort(list, Comparator.comparingInt(String::length).
//                thenComparing(Comparator.comparing(String::toLowerCase, Comparator.reverseOrder())));
//        Collections.sort(list, Comparator.comparingInt(String::length).thenComparing(String::toLowerCase, Comparator.reverseOrder()));
//        Collections.sort(list, Comparator.comparingInt(String::length).reversed().thenComparing(String::toLowerCase, Comparator.reverseOrder()));

        Collections.sort(list,  Comparator.comparingInt(String::length).reversed().
                thenComparing(String::toLowerCase, Comparator.reverseOrder()).
                thenComparing(Comparator.reverseOrder()));

        System.out.println(list);

    }
}
