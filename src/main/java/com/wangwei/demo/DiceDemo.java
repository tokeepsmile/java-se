package com.wangwei.demo;


/**
 * 线程a负责随机掷一次骰子
 * 线程b负责将线程a的结果输出到屏幕上
 * 如果连续输出都为3,a，b线程退出
 *
 * @Auther wangwei
 * @Date 2018/4/26 下午6:08
 */

public class DiceDemo {

    private static volatile boolean flag = true;
    private static int count;

    public static void main(String[] args) {
        A a = new A();
        while (flag) {
            new Thread(a).start();
            if (a.getNum() != 0) {
                new Thread(new B(a)).start();
            }
            if (a.getNum() == 3) {

                count++;
                if (count == 3) {
                    flag = false;
                    System.out.println("累计连续输出3个3,进程结束！！！");
                }
            } else {
                count = 0;
            }
        }
    }

    static class A implements Runnable {
        private int num;

        public int getNum() {
            return num;
        }

        @Override
        public void run() {
            this.num = (int) (Math.random() * 6 + 1);
        }
    }

    static class B implements Runnable {

        private A a;

        public B(A a) {
            this.a = a;
        }

        @Override
        public void run() {

            System.out.println(a.getNum());
        }
    }
}
