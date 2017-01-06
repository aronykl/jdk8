package com.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Description: Created with IntelliJ IDEA.
 * @Author: zhouwen
 * @Date: 2017/1/6 23:32
 */
public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        PredicateTest2 predicateTest2 = new PredicateTest2();
        predicateTest2.conditionFilter(list, integer -> integer % 2 == 0);

        System.out.println("---------------------------");
        predicateTest2.conditionFilter(list, integer -> integer % 2 != 0);

        System.out.println("---------------------------");
        predicateTest2.conditionFilter(list, integer -> integer > 5);

        System.out.println("---------------------------");
        predicateTest2.conditionFilter(list, integer -> integer < 3);

        System.out.println("---------------------------");
        predicateTest2.conditionFilter(list, integer -> true);

        System.out.println("---------------------------");
        predicateTest2.conditionFilter(list, integer -> false);

        System.out.println("---------------------------");
        predicateTest2.conditionFilter2(list, integer -> integer > 5, integer -> integer % 2 == 0);

    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(integer -> {
            if (predicate.test(integer))
                System.out.println(integer);
        });
    }

    public void conditionFilter2(List<Integer> list, Predicate<Integer> predicate,
                                Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if(predicate.and(predicate2).negate().test(integer))
                System.out.println(integer);
        });
    }
}
