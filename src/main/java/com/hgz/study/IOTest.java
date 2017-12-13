package com.hgz.study;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:53
 * @Description:
 * @Motifiedy by:
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOTest {
    private int b;
    public IOTest() {
        b = 0;
    }
    public void test() {
        System.out.println("*******************IO Testing*******************");
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
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a number");
            b = in.nextInt();
            System.out.println("Enter a string");
            in.nextLine();
            String s = in.nextLine();
            System.out.println("you Entered: " + b + " " + s);
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
        }

        System.out.println("standard System output stream test");
    }
    private void fileIOTest() {
        //File create
        File fl = new File("./tmp.txt");
        try {
            if(!fl.exists()) {
                fl.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            return;
        }
        try {
            FileOutputStream wrf = new FileOutputStream(fl);
            String filecontent = "FileInput/OutputStream write and read test successfully";
            wrf.write(filecontent.getBytes() ,0 ,filecontent.getBytes().length);

            wrf.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //FileInputStream
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(fl);
            byte[] buf = new byte[1024];
            while(fis.read(buf) != -1) {
                System.out.print(new String(buf));
            }
            System.out.println("");
            fis.close();
            fl.delete();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        //FileReader
        try {
            FileWriter fwr = new FileWriter(fl);
            String filecontent = "FileReader/Writer write and read test successfully";
            fwr.write(filecontent);
            fwr.close();
            FileReader frd = new FileReader(fl);
            char[] buf = new char[1024];
            while(frd.read(buf) != -1) {
                System.out.print(new String(buf));
            }
            System.out.println("");
            frd.close();
            fl.delete();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
        //BufferedReader
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fl));
            String filecontent = "BufferedReader/Writer write and read test successfully";
            bw.write(filecontent);
            bw.close();
            BufferedReader br = new BufferedReader(new FileReader(fl));
            System.out.println(br.readLine());
            br.close();
            fl.delete();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
    private void netIOTest() {

    }
}
