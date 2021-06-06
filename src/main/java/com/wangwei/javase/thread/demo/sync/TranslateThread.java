package com.wangwei.javase.thread.demo.sync;

import java.util.concurrent.CountDownLatch;

/**
 * @Author wangwei
 * @Date 2020/11/24 下午6:45
 * @Version 1.0
 */
public class TranslateThread extends Thread {
    private CountDownLatch countDownLatch;
    private String content;
    public TranslateThread(CountDownLatch countDownLatch, String content){
        this.content = content;
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {
        if (Math.random() > 0.5){
            throw new RuntimeException("原文存在非法字符");
        }
        System.out.println(content + "的翻译已经完成，译文是........");
        countDownLatch.countDown();
    }
}
