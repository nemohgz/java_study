package com.hgz.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
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
        System.out.println("*******************Collection Testing*******************");
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
        HashSet<String> hset = new HashSet<>();
        hset.add("123");
        hset.add("234");
        hset.add("345");
        hset.add("123");
        System.out.println("HashSet Testing");
        System.out.println("the HashSet is : " + Arrays.toString(hset.toArray()));
        System.out.println("HashSet Iterator");
        Iterator<String> iter = hset.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        hset.remove("123");
        System.out.println("remove \"123\"");
        System.out.println("the HashSet now is : " + Arrays.toString(hset.toArray()));
        System.out.println("the HashSet contains \"234\" is " + hset.contains("234"));
        TreeSet<String> tset = new TreeSet<>();
        tset.add("123");
        tset.add("234");
        tset.add("132");
        tset.add("243");
        System.out.println("TreeSet Testing");
        System.out.println(tset);
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
        HashMap<String,Integer> table = new HashMap<>();
        table.put("abc", 1);
        table.put("def", 2);
        table.put("ghi", 3);
        System.out.println("Map Testing");
        System.out.println(table.toString());
        table.put("ghi", 2);
        System.out.println("put ghi = 2 " + table.toString());
        Iterator iter = table.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry  entry =  (Map.Entry) iter.next();

            System.out.println("k=" +  entry.getKey() + "  v=" + entry.getValue());
        }
         //
        iter = table.keySet().iterator();
        System.out.println("keyset visit way:");
        while (iter.hasNext()) {
            Object key  = iter.next();
            System.out.println("k=" +  key + "  v=" + table.get(key));
        }
        Set<Map.Entry<String,Integer>> allEntris = table.entrySet();
        //allEntris.remove(allEntris.iterator().next());
        //System.out.println(table);
        TreeMap<String,Integer> tmap = new TreeMap<>();
        tmap.put("def", 2);
        tmap.put("ghi", 3);
        tmap.put("abc", 1);
        System.out.println("TreeMap Testing");
        for (Map.Entry entry: tmap.entrySet()) {
            System.out.println("k=" +  entry.getKey() + "  v=" + entry.getValue());
        }

    }

    public static void main(String[] args) {
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.test();
    }
}
