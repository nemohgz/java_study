package com.hgz.study;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:57
 * @Description:
 * @Motifiedy by:
 */
public class StringTest {
    public StringTest(){}
    public void test() {
        System.out.println("*******************String Testing*******************");
        constructTest();
        modifiedTest();
        stringBufferTest();
    }
    public void constructTest() {
        char[] s = new char[]{'a', 'b', 'c'};
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = new String(s);
        String s4 = "abc";
        String s5 = s1.intern();
        System.out.println("using s = \"\" ,s1 = " + s1);
        System.out.println("using s = new string(\"\"), s2 = " + s2);
        System.out.println("using s = new string(char[]), s3 = " + s3);
        System.out.println("using s = \"\", s4 = " + s4);
        System.out.println("using s = s1.intern(), s5 = " + s5);
        System.out.println("s1 == s2 is " + (s1==s2));
        System.out.println("s1.equals(s2) is "+ s1.equals(s2));
        System.out.println("s1 == s4 is " + (s1==s4));
        System.out.println("s1.equals(s4) is "+ s1.equals(s4));
        System.out.println("s1 == s5 is " + (s1==s5));
        System.out.println("s1.equals(s5) is "+ s1.equals(s5));
        System.out.println("s2 == s3 is " + (s2==s3));
        System.out.println("s2.equals(s3) is "+ s2.equals(s3));

    }
    public void modifiedTest() {
        String s = "123abc";
        String s1 = s.substring(0);
        String s2 = s.substring(0, s.length());
        System.out.println("s.substring(0) is " + s1);
        System.out.println("s.substring(0, s.length()) is " + s2);
        System.out.println(s.indexOf("123"));
        System.out.println(s.lastIndexOf("abc"));
    }
    public void stringBufferTest() {
        final int TEST_TIMES = 10000;


        long beforeTestTime;
        long afterTestTime;
        //test 1
        beforeTestTime = System.currentTimeMillis();
        String s = "test";
        for (int i = 0; i < TEST_TIMES; i++) {
            s = s + "java";
        }
        afterTestTime = System.currentTimeMillis();
        System.out.println("using s+= \"\" do "+ TEST_TIMES + " times cost: "
            + (afterTestTime - beforeTestTime) + "ms");
        //test 2
        beforeTestTime = System.currentTimeMillis();
        StringBuffer  sbuf = new StringBuffer("test");
        for (int i = 0; i < TEST_TIMES; i++) {
            sbuf.append("java");
        }
        String sbuftmp = sbuf.toString();
        afterTestTime = System.currentTimeMillis();
        System.out.println("using StringBuffer.append do "+ TEST_TIMES + " times cost: "
                + (afterTestTime - beforeTestTime) + "ms");
        //
        beforeTestTime = System.currentTimeMillis();
        StringBuilder sbud = new StringBuilder("test");
        for (int i = 0; i < TEST_TIMES; i++) {
            sbud.append("java");
        }
        String sbudtmp = sbud.toString();
        afterTestTime = System.currentTimeMillis();
        System.out.println("using StringBuilder.append do "+ TEST_TIMES + " times cost: "
                + (afterTestTime - beforeTestTime) + "ms");

    }
}