package com.shengsiyuan.jdk8.stream2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * 自定义收集器
 * @Author: zhouwen
 * @Date: 2017/3/12 11:08
 */
public class MySetCollector2<T> implements Collector<T, Set<T>, Map<T, T>> {

    @Override
    public Supplier<Set<T>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
//        return Set<T>::add;
        return (set, item) -> {
//            System.out.println("accumulator: " + set + ", " + Thread.currentThread().getName());
            set.add(item);
        };
    }


    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        return (Set<T> set) -> {
            Map<T, T> map = new HashMap<T, T>();
            set.forEach(t -> map.put(t, t));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, CONCURRENT));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            List<String> list = Arrays.asList("hello", "world", "welcome", "hello world", "a", "b", "c", "d", "e", "f", "g");
            Map<String, String> map = list.parallelStream().collect(new MySetCollector2<>());
            System.out.println(map);
        }

    }
}
