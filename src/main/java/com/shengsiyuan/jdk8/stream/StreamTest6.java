package com.shengsiyuan.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 15:13
 */
public class StreamTest6 {
    public static void main(String[] args) {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        System.out.println(stream.findFirst().get());//不建议
//        System.out.println(stream.findFirst().orElse("null"));

//        Stream.iterate(1, item -> 2 + item).limit(20).forEach(System.out::println);

//        System.out.println(Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).
//                map(item -> item * 2).skip(2)
//                .limit(2).reduce(0, Integer::sum));

        IntStream stream = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 200)
                .mapToInt(item -> item * 2).skip(2).limit(2);
//        System.out.println(stream.count());
//        System.out.println(stream.sum());
//        System.out.println(stream.max());
//        System.out.println(stream.min());

        IntSummaryStatistics summaryStatistics = stream.summaryStatistics();
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getSum());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getMax());
    }
}
