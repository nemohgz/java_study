package com.hgz.study;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:40
 * @Description:
 * @Motifiedy by:
 */
public class Main {
    public static void main(String[] args) {
        IOTest ioTest = new IOTest();
        ioTest.test();
        StringTest stringTest = new StringTest();
        stringTest.test();
        ArrayTest arrayTest = new ArrayTest();
        arrayTest.test();
        CollectionTest collectionTest = new CollectionTest();
        collectionTest.test();
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.test();
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.test();
        ThreadTest threadTest = new ThreadTest();
        threadTest.test();
        if (EventTest.operateSystemSupported()) {
            EventTest eventTest = new EventTest();
            eventTest.test();
        } else {
            System.out.println("Linux System skip EventTest");
        }
        AlgorithmTest algorithmTest = new AlgorithmTest();
        algorithmTest.test();
        ReflectTest reflectTest = new ReflectTest();
        reflectTest.test();
    }
}
