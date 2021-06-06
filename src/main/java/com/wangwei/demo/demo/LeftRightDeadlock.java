package com.wangwei.demo.demo;

public class LeftRightDeadlock extends Thread {
    private final Object left = new Object();
    private final Object right = new Object();


    public void leftRight() {
        synchronized (left) {
            System.out.println("leftRight left");
            synchronized (right) {
                System.out.println("leftRight right");
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            System.out.println("rightLeft right");
            synchronized (left) {
                System.out.println("rightLeft left");
            }
        }
    }

    public static void main(String[] args) {

    }
}
