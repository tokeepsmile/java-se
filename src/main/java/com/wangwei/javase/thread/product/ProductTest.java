package com.wangwei.javase.thread.product;

/**
 * @Author wangwei
 * @Date 2021/1/8 上午10:35
 * @Version 1.0
 */
public class ProductTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Product product = new Product(resource);
        Consumer consumer = new Consumer(resource);

        new Thread(product).start();
        new Thread(product).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
