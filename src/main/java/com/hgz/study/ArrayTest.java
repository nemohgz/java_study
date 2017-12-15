package com.hgz.study;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:58
 * @Description:
 * @Modified by:
 */
public class ArrayTest {
    public ArrayTest(){}
    public void test() {
        System.out.println("*******************Array Testing*******************");
        arrayTest();
        arrayListTest();
    }
    public void arrayTest() {
        String[]  aArray = new String[5];
        String[]  bArray = {"a", "b", "c", "d", "e"};
        String[]  cArray = new String[]{"1", "3", "2", "5", "4"};
        System.arraycopy(bArray, 0, aArray, 0, aArray.length);
        System.out.println(aArray);
        System.out.println(Arrays.toString(aArray));
        String[] dArray = Arrays.copyOf(cArray, cArray.length);
        Arrays.sort(dArray);
        System.out.println(Arrays.toString(dArray));
    }
    public  void arrayListTest() {
        ArrayList<String>  alist = new ArrayList<>();
        alist.add("a");
        alist.add("b");
        alist.add("c");
        String[] bArray = alist.toArray(new String[]{});
        for (String e: bArray) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.test();
    }
}
