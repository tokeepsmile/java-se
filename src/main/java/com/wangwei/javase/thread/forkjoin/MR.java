package com.wangwei.javase.thread.forkjoin;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;

/**
 * @Author wangwei
 * @Date 2021/2/2 下午4:26
 * @Version 1.0
 */
public class MR extends RecursiveTask<Map<String, Long>> {

    private String[] fc;

    private int start, end;

    public MR(String[] fc, int start, int end) {
        this.fc = fc;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Map<String, Long> compute() {
        if (end - start == 1){
            return cacl(fc[start]);
        }else {
            int mid = (start + end) / 2;
            MR mr1 = new MR(fc, start, mid);
            mr1.fork();
            MR mr2 = new MR(fc, mid, end);
            return merge(mr2.compute(), mr1.join());
        }
    }

    private Map<String, Long> merge(Map<String, Long> result1, Map<String, Long> result2){
        Map<String, Long> result = new HashMap<>(result1);
        result2.forEach((k, v) -> {
            Long aLong = result.get(k);
            if (Objects.nonNull(aLong)){
                result.put(k, v + aLong);
            }else {
                result.put(k, 1L);
            }
        });
        return result;
    }
    
    private Map<String, Long> cacl(String line){
        Map<String, Long> result = new HashMap<>();
        String[] words = line.split("\\s+");
        for (String w : words) {
            Long l = result.get(w);
            if (Objects.isNull(l)){
                result.put(w, 1L);
            }else {
                result.put(w, l + 1L);
            }
        }
        return result;
    }
}
