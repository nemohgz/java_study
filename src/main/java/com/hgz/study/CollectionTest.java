package com.hgz.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Set;
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
        List<String> slist = new ArrayList<String>();
        slist.add("1");
        slist.add("2");
        slist.add("3");
        Iterator<String> iter = slist.iterator();
        System.out.println("Iterator Testing");
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
        ListIterator<String> listIter = slist.listIterator();
        System.out.println("ListIterator  Previous Testing");
        while(listIter.hasNext()) {
            listIter.next();
        }
        while(listIter.hasPrevious()) {
            System.out.println(listIter.previous());
        }
        listIter.next();
        listIter.remove();
        System.out.println("now remove first element");
        while(listIter.hasNext()) {
            System.out.println(listIter.next());
        }
    }
    public void setTest() {

    }
    public void  queueTest() {
        //
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(100);
        abq.add("123");
        abq.offer("234");
        abq.offer("345");
        System.out.println("ArrayBlockingQueue Testing");
        System.out.println(Arrays.toString(abq.toArray()));
        System.out.println(abq.poll());
        System.out.println(abq.remove());
        System.out.println(abq.poll());
        //
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>(100);
        lbq.add("abc");
        lbq.offer("def");
        lbq.offer("ghi");
        System.out.println("LinkedBlockingQueue Testing");
        System.out.println(Arrays.toString(lbq.toArray()));
        System.out.println(lbq.poll());
        System.out.println(lbq.remove());
        System.out.println(lbq.poll());
        //
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("132");
        pq.add("123");
        pq.add("231");
        pq.add("213");
        System.out.println("PriorityQueue Testing");
        while ( pq.peek() != null) {
            System.out.println(pq.poll());
        }
    }
    public void mapTest() {

    }

    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.test();
    }
}
