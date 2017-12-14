package com.hgz.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 15:05
 * @Description:
 * @Modified by:
 */
public class ExceptionTest {

    public ExceptionTest() {

    }
    public void  test() {
        System.out.println("**************Exception Test**************");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e){

        }
        try {
            checkedExceptionTest();
        } catch (IOException e) {
            System.err.println("checkedException");
            System.err.println("Class: " + e.getClass());
            System.err.println("Cause: " + e.getCause());
            System.err.println("Message: " + e.getMessage());
            System.err.println("StackTrace: " + Arrays.toString(e.getStackTrace()));
        }
        uncheckedExceptionTest();
    }
    private void  checkedExceptionTest()  throws FileNotFoundException {
        IOExceptionTest();
    }
    private void IOExceptionTest() throws FileNotFoundException {
        //IOEXception
        FileReader fr = new FileReader("./tmp.tx");
    }
    private void  uncheckedExceptionTest() {
        String[] sArray = new String[]{"a","b"};
        try {
            sArray[2] = "c";
        } catch (RuntimeException e) {
            System.err.println("uncheckedException");
            e.printStackTrace();
        } finally {
            System.err.println("do finally part");
        }
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.test();
    }
}
