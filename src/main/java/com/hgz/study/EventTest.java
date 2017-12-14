package com.hgz.study;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 15:00
 * @Description:
 * @Modified by:
 */
public class EventTest{
    private Frame f;
    private Button bt;
    public EventTest() {
        f = new Frame("EventTest");
        bt = new Button("change color");
        bt.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bt.setBackground(Color.RED);
                    }
                }
        );
        f.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                }
        );
    }
    public void test() {
        f.add(bt);
        f.setSize(480,200);
        f.setLocation (200,400);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        EventTest eventTest = new EventTest();
        eventTest.test();
    }
}
