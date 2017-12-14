package com.hgz.study;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 15:00
 * @Description:
 * @Modified by:
 */
class TestThread1 extends  Thread {
    private String name;
    public  TestThread1(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println("create thread by extending Class of Thread");
        System.out.println("run Thread of " + this.name);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + " run " + i);
        }
    }
}
class TestThread2 implements Runnable {
    private String name;
    public  TestThread2(String name) {
        this.name = name;
    }
    public void run() {
        System.out.println("create thread by implements Runnable Interface");
        System.out.println("run Thread of " + this.name);
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + " run " + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ThreadTest {
    public ThreadTest() {

    }
    public void test() {
        System.out.println("*******************Thread Testing*******************");
        TestThread1 th1 = new TestThread1("thread1");
        th1.start();
        TestThread2 th2 = new TestThread2("thread2");
        new Thread(th2).start();
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.test();
    }

}
