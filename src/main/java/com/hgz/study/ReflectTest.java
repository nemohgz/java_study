package com.hgz.study;

import com.sun.org.apache.regexp.internal.RE;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @Author: HGZ
 * @Date: 2017-12-07
 * @Time: 14:59
 * @Description:
 * @Modified by:
 */
class TestClass {
    private int value;
    private String name;
    public  TestClass() {
        name = "Test";
        value = 0;
    }
    public  TestClass(String name, int value) {
        this.name = name;
        this.value = value;
    }
    public void test() {
        System.out.println(this.getClass() + " value="  + this.value + " name=" + this.name);
    }
    private void printMessage(String message) {
        System.out.println("call private method: " + message);
    }
}
public class ReflectTest {
    public ReflectTest() {
    }
    public  void test() {
        //
        System.out.println("*********************Reflect Testing*********************");
        TestClass testClass = new TestClass("hgz", 100);
        testClass.test();
        try {
            TestClass rClass = (TestClass) Class.forName(testClass.getClass().getName())
                                           .getConstructor(String.class, int.class)
                                           .newInstance(new Object[]{"nemo", 90});
            rClass.test();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Class c = TestClass.class;
        Field[] fields = c.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("get TestClass Info by refect\n");
        sb.append(Modifier.toString(c.getModifiers())+ " class " + c.getSimpleName() + "{\n");
        for ( Field f: fields) {
            sb.append(Modifier.toString(f.getModifiers()) + " ");
            sb.append(f.getType().getSimpleName() + " ");
            sb.append(f.getName() + ";\n");
        }
        Method[] methods = c.getDeclaredMethods();
        for ( Method m: methods) {
            sb.append(Modifier.toString(m.getModifiers()) + " ");
            sb.append(m.getReturnType() + " ");
            sb.append(m.getName() + "(");
            Parameter[] parameters = m.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                sb.append(parameters[i].getType().getSimpleName());
                if (i != parameters.length -1) {
                    sb.append(", ");
                }
            }
            sb.append(");\n");
        }
        sb.append("}\n");
        System.out.print(sb.toString());
        try {
            Method pm = c.getDeclaredMethod("printMessage", String.class);
            pm.setAccessible(true);
            pm.invoke(testClass,"printMessage method by reflect");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReflectTest reflectTest = new ReflectTest();
        reflectTest.test();
    }
}
