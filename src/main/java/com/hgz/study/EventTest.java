package com.hgz.study;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


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
    private Random colorRandom;
    private int x = 190;
    private int y = 75;
    public EventTest() {
        colorRandom = new Random();
        f = new Frame("EventTest");
        bt = new Button("change color");
        bt.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int r = colorRandom.nextInt(255);
                        int g = colorRandom.nextInt(255);
                        int b = colorRandom.nextInt(255);
                        //bt.setBackground(new Color(r, g, b));
                        f.setBackground(new Color(r, g, b));
                        f.requestFocus();
                    }
                }
        );
        f.addKeyListener(
                new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {

                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_DOWN:y += 20;break;
                            case KeyEvent.VK_UP: y -= 20;break;
                            case KeyEvent.VK_LEFT: x -= 20;break;
                            case KeyEvent.VK_RIGHT: x += 20;break;
                        }
                        y = y<0 ? 0: y;
                        y = y>f.getHeight()-25 ? f.getHeight() - 25 : y;
                        x = x<0 ? 0: x;
                        x = x>f.getWidth()-80 ? f.getWidth() - 80 : x;
                        //bt.setBounds(x,y,80,25);
                        int r = colorRandom.nextInt(255);
                        int g = colorRandom.nextInt(255);
                        int b = colorRandom.nextInt(255);
                        //bt.setBackground(new Color(r, g, b));
                        Graphics gpen = e.getComponent().getGraphics();
                        //f.update(gpen);
                        gpen.setColor(new Color(r, g, b));
                        gpen.fillOval(x,y,30,30);
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
        f.setLayout(null);
        bt.setBounds(190,75,80,25);
        f.add(bt, BorderLayout.EAST);
        f.setSize(480,200);
        f.setLocation (200,400);
        f.setFocusable(true);
        f.setVisible(true);
    }
    public  static boolean  operateSystemSupported() {
        return System.getProperties().getProperty("os.name").toLowerCase().contains("windows");
    }
    public static void main(String[] args) {
        EventTest eventTest = new EventTest();
        eventTest.test();
    }
}
