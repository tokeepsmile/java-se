package com.wangwei.javase.thread.demo.reference;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author wangwei
 * @Date 2021/4/12 11:05 下午
 * @Version 1.0
 */
public class CsGameByThreadLocal {
    private static final Integer BULLET_NUMBER = 1500;

    private static final Integer KILLED_NUMBER = 0;

    private static final Integer LIFE_VALUE = 10;

    private static final Integer TOTAL_PLAYERS = 10;

    // 随机数来展示每个对象的不同数据
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL = new ThreadLocal(){
        @Override
        protected Integer initialValue() {
            return BULLET_NUMBER;
        }
    };

    private static final ThreadLocal<Integer> KILLED_NUMBER_THREADLOCAL = ThreadLocal.withInitial(() -> KILLED_NUMBER);

    private static final ThreadLocal<Integer> LIFE_VALUETHREADLOCAL = ThreadLocal.withInitial(() -> LIFE_VALUE);

    private static class Player extends Thread {
        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);

            Integer killEnemies = KILLED_NUMBER_THREADLOCAL.get() + RANDOM.nextInt(TOTAL_PLAYERS/2);

            Integer lifeValue = LIFE_VALUETHREADLOCAL.get() - RANDOM.nextInt(LIFE_VALUE);

            System.out.println(getName() + ", BULLET_NUMBER is " + bullets);
            System.out.println(getName() + ", KILL_ENEMIES is " + killEnemies);
            System.out.println(getName() + ", LIFE_VALUE is " + lifeValue);
            System.out.println();

            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_NUMBER_THREADLOCAL.remove();
            LIFE_VALUETHREADLOCAL.remove();
        }
    }

    public static void main(String[] args) {
        for (Integer i = 0; i < TOTAL_PLAYERS; i++) {
            new Player().start();
        }
    }
}
