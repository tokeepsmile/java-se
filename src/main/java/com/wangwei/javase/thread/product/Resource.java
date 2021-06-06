package com.wangwei.javase.thread.product;

/**
 * @Author wangwei
 * @Date 2021/1/8 上午10:26
 * @Version 1.0
 */
public class Resource {
    private String name;
    private int count;
    private boolean flag = false;

    public synchronized void input(String name){
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "--" + count++;
        System.out.println(Thread.currentThread().getName() + "--生产者--" + this.name);
        flag = true;
        notifyAll();
    }

    public synchronized void output(){
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "------消费者------" + this.name);
        flag = false;
        notifyAll();
    }
}
