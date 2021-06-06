package com.wangwei.javase.proxy.staticProxy;

/**
 * @Auther wangwei
 * @Date 2018/5/5 下午2:44
 */
public class Test {
    public static void main(String[] args) {

//        ExtendCarProxy extendsCar = new ExtendCarProxy();
//        extendsCar.move();
//
//        Car car = new Car();
//        JHCarProxy jhCar = new JHCarProxy(car);
//        jhCar.move();
        Car car = new Car();
        CarLogProxy carLogProxy = new CarLogProxy(car);
        CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
        carTimeProxy.move();
    }


}
