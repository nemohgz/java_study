package com.hgz.study;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:53
 * @Description:
 * @Motifiedy by:
 */


import java.util.Scanner;

public class IOTest {
    private int b;
    public IOTest() {
        b = 0;
    }
    public void test() {
        consoleIOTest();
        fileIOTest();
        netIOTest();
    }
    private void consoleIOTest() {
        //java system.in
        /*try {
            System.out.println("Please input a sequence:");
            while((b = System.in.read()) != -1) {
                System.out.print((char)b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            byte[] readarray = new byte[10];
            System.out.println("Please input a char sequence:");
            System.in.read(readarray);
            for (int i = 0; i < readarray.length; ++i) {
                System.out.print((char)readarray[i]);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }*/
        //java bufferreader
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter a number");
            b = Integer.parseInt(br.readLine());
            System.out.println("Enter a string");
            String s = br.readLine();
            System.out.println("you Entered: " + b + " " + s);
        } catch (IOException e) {
            System.out.println(e.toString());
        }*/
        //java scanner
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a number");
        b = in.nextInt();
        System.out.println("Enter a string");
        String s = in.nextLine();
        System.out.println("you Entered: " + b + " " + s);

        System.out.println("standard System output stream test");
    }
    private void fileIOTest() {
        //FileInputStream
        //FileInputStream fis = new FileInputStream()
        //FileReader
        //BufferedReader
    }
    private void netIOTest() {

    }
}
