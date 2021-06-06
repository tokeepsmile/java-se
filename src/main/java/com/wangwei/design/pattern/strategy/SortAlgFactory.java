package com.wangwei.design.pattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangwei
 * @Date 2020/4/27 5:42 下午
 * @Version 1.0
 */

public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return algs.get(type);
    }
}

