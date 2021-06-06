package com.wangwei.demo.demo;

public class LeftRightDeadlockRun implements Runnable {


    private boolean flag;

    private LeftRightDeadlock ldl;


    public LeftRightDeadlockRun(boolean flag, LeftRightDeadlock ldl) {
        this.flag = flag;
        this.ldl = ldl;
    }

    @Override
    public void run() {
        if (flag)
            new LeftRightDeadlock().leftRight();
        else
            new LeftRightDeadlock().rightLeft();
    }

    public static void main(String[] args) {
        LeftRightDeadlock leftRightDeadlock = new LeftRightDeadlock();
        new Thread(new LeftRightDeadlockRun(true, leftRightDeadlock)).start();
        new Thread(new LeftRightDeadlockRun(false, leftRightDeadlock)).start();
    }
}
