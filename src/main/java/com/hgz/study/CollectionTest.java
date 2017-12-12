package com.hgz.study;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author: HGZ
 * @Date: 2017-12-12
 * @Time: 14:41
 * @Description:
 * @Motifiedy by:
 */
public class CollectionTest {
    public CollectionTest(){}
    public void test() {
        listTest();
        setTest();
        queueTest();
        mapTest();
    }
    public void listTest() {

    }
    public void setTest() {

    }
    public void  queueTest() {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(100);
        abq.add("123");
        abq.offer("234");
        abq.offer("345");
        System.out.println(Arrays.toString(abq.toArray()));
        System.out.println(abq.poll());
        System.out.println(abq.remove());
        System.out.println(abq.poll());
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>(100);
        lbq.add("abc");
        lbq.offer("def");
        lbq.offer("ghi");
        System.out.println(Arrays.toString(lbq.toArray()));
        System.out.println(lbq.poll());
        System.out.println(lbq.remove());
        System.out.println(lbq.poll());
    }
    public void mapTest() {

    }

    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.test();
    }
}
