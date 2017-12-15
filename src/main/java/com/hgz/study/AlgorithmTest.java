package com.hgz.study;

import com.sun.org.apache.bcel.internal.generic.ALOAD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 15:02
 * @Description:
 * @Modified by:
 */
public class AlgorithmTest {
    public AlgorithmTest() {

    }
    public void test() {
        System.out.println("*******************Algorithm Testing*******************");
        List<String>  listS = new ArrayList<>();
        listS.add("123");
        listS.add("213");
        listS.add("132");
        listS.add("212");
        System.out.println("original list:" + listS.toString());
        Collections.sort(listS);
        System.out.println("after sort list:" + listS.toString());
        System.out.println("element 213 index is "
                + Collections.binarySearch(listS,"213"));
        List<String> listS2 = new LinkedList<String>();
        listS2.addAll(listS);
        Collections.shuffle(listS2);
        System.out.println("after shuffle list2:" + listS2.toString());
        Collections.sort(listS2);
        System.out.println("after sort list2:" + listS2.toString());
    }

    public static void main(String[] args) {
        AlgorithmTest algorithmTest = new AlgorithmTest();
        algorithmTest.test();
    }
}
