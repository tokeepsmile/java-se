package com.wangwei.javase.thread.product;

/**
 * @Author wangwei
 * @Date 2021/1/8 上午10:34
 * @Version 1.0
 */
public class Consumer implements Runnable {
    private Resource resource;

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            resource.output();
        }
    }
}
