package com.wangwei.javase.thread.test;

/**
 * @Author wangwei
 * @Date 2021/1/11 上午10:08
 * @Version 1.0
 */
public class Profiler {
    private static final ThreadLocal<Long> THREAD_LOCAL = ThreadLocal.withInitial(System::currentTimeMillis);

    public static final void begin(){
        THREAD_LOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis() - THREAD_LOCAL.get();
    }

    public static void main(String[] args) {
        Profiler.begin();
        SleepUtils.second(1);
        System.out.println("Cost: " + Profiler.end() + " mills");
    }
}
