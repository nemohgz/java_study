package com.hgz.study;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 15:01
 * @Description:
 * @Modified by:
 */
interface  RvIter<E> extends  Iterator<E>,Iterable<E>{
    void setCurrentData(E e);
}
final class RvArray<E> implements RvIter<E> {
    private  Object[] eArray;
    private int index = 0;
    public RvArray(int sz) {
        assert(sz>=0);
        eArray = new Object[sz];
    }
    public  Iterator iterator() {
        index = eArray.length;
        return this;
    }
    public boolean hasNext() {
        return (index>0);
    }
    public E next() {
        if (index > 0) {
            return (E)eArray[--index];
        } else {
            return  null;
        }
    }
    public void setCurrentData(E e) {
        eArray[index] = e;
    }
    public String toString() {
        return Arrays.toString(eArray);
    }
}
public class InterfaceTest {
    public InterfaceTest(){}
    public void test() {
        System.out.println("**************Interface Testing*****************");
        RvIter<Double> rIter = new RvArray<>(4);
        Iterator iter = rIter.iterator();
        int i = 0;
        while (iter.hasNext()) {
            iter.next();
            rIter.setCurrentData(0.0+(i++));
        }
        System.out.println("original data is "  + rIter.toString());
        System.out.println("visit by reIter Interface is ");
        /*iter = rIter.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }*/
        for (Double e: rIter) {
            System.out.print(e + " ");
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.test();
    }

}
