package com.wangwei.javase.thread.product;

/**
 * @Author wangwei
 * @Date 2021/1/8 上午10:32
 * @Version 1.0
 */
public class Product implements Runnable {
    private Resource resource;

    public Product(Resource resource) {
        this.resource = resource;
    }


    @Override
    public void run() {
        while (true){
            resource.input("Iphone");
        }
    }
}
