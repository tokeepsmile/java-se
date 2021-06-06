package com.wangwei.javase.func;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author wangwei
 * @Date 2021/4/15 10:53 下午
 * @Version 1.0
 * java为函数式编程引入三个新的语法概念: Stream类, lambda表达式，函数式接口。
 *
 */
public class StreamDmeo {
    public static void main(String[] args) {
        Optional<Integer> result = Stream.of("f", "ba", "hello")
                .map(s -> s.length())
                .filter(i -> i <= 3)
                .max((s1, s2) -> s1 - s2);
        System.out.println(result.get());

        // 函数接口实现方式
        Optional<Integer> sorted = Stream.of("cafebabe", "moshu", "ha")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer <= 3;
                    }
                })
                .max(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
        System.out.println(sorted);
    }
}
