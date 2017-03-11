package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 10:50
 */
public class StreamTest3 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(list.stream().map(item -> item * 2).reduce(0, Integer::sum));
    }
}
