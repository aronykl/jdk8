package com.shengsiyuan.jdk8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/2/5 11:27
 */
public class StreamTest4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");
//        String[] strings = stream.toArray(length -> new String[length]);

//        String[] strings = stream.toArray(String[]::new);
//        Arrays.asList(strings).forEach(System.out::println);

//        List<String> list = stream.collect(Collectors.toList());
//        list.forEach(System.out::println);

//        List<String> list = stream.collect(() -> new ArrayList<String>(), (arrayList, str) -> arrayList.add(str),
//                (arrayList1, arrayList2) -> arrayList1.addAll(arrayList2));
//        list.forEach(System.out::println);
//        List<String> list = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
//        List<String> list = stream.collect(LinkedList::new, LinkedList::add, (arrayList1, arrayList2) -> {return;});
//        list.forEach(System.out::println);
//        List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
//        list.forEach(System.out::println);

//        Set<String> set = stream.collect(Collectors.toSet());
//        System.out.println(set.getClass());
//        set.forEach(System.out::println);

//        Set<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
//        System.out.println(set.getClass());
//        set.forEach(System.out::println);

        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);

    }
}
