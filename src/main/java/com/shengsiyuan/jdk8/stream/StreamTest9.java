package com.shengsiyuan.jdk8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/7 09:09
 */
public class StreamTest9 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序...");

        long startTime = System.nanoTime();

//        list.stream().sorted().count();
        list.parallelStream().sorted().count();
//        Collections.sort(list);
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时：" + millis);
    }
}
