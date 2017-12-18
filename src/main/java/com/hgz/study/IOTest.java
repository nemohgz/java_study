package com.hgz.study;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:53
 * @Description:
 * @Motifiedy by:
 */


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class IOTest {
    private int b;
    private static final int PORT = 10086;
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
          if (EventTest.operateSystemSupported()) {
              ClientTest clientTest = new ClientTest(this.PORT);
              new Thread(clientTest).start();
          } else {
              ServerTest serverTest = new ServerTest(this.PORT);
              new Thread(serverTest).start();
          }
    }
    class ServerTest implements  Runnable{
        private ServerSocket serverSocket;

        public ServerTest(int port) {
            try {
                this.serverSocket = new ServerSocket(port);
            } catch (IOException e) {
                System.out.println("cannot start server of port:" + PORT);
                e.printStackTrace();
            }
        }
        public void run() {
            startServer();
        }
        private void startServer() {
            if (serverSocket == null) return;
            Socket client = null;
            try {
                client = serverSocket.accept();
                while (true) {
                    DataInputStream in = new DataInputStream(client.getInputStream());
                    StringBuffer sb = new StringBuffer();
                    sb.append("I am server ");
                    sb.append("reply your message -->");
                    String clientString = in.readUTF();
                    System.out.println("server:client say " + clientString);
                    sb.append(clientString);
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF(sb.toString());
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                System.out.println("server closed for exception: " + e.getMessage());
            } finally {
                if (client != null) {
                    try {
                        client.close();
                        client = null;
                    } catch (IOException e) {

                    }
                }
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                        serverSocket = null;
                    } catch (IOException e) {

                    }
                }
            }
        }
    }
    class ClientTest implements  Runnable{
        private static final String SERVER_IP = "47.100.110.207";
        private Socket clientSocket;

        public ClientTest(int port) {
            try {
                clientSocket = new Socket(SERVER_IP, port);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("cannot create client socket");
            }
        }
        public  void run() {
            connectServer();
        }
        private void connectServer() {
            try {
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Hi I am a client");
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                System.out.println("client: server say " + in.readUTF());
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                        clientSocket = null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        IOTest ioTest = new IOTest();
        ioTest.test();
    }
}
