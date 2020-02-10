package com.study.javacore.reflex;

import java.lang.reflect.Method;

public class ReflexDemo {

    public static void main(String[] args) throws Exception {
        Class clazz = ReflexDemo.class;
        ReflexDemo demo = (ReflexDemo) clazz.newInstance();
        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getPackage());
        System.out.println(clazz.getClassLoader());
        methodLog();
    }

    public static void methodLog() throws Exception{
        Class clazz = ReflexDemo.class;
        ReflexDemo reflexDemo = (ReflexDemo) clazz.newInstance();
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        /*for (int i = 0;i<methods.length;i++){
            System.out.println(methods[i]);
        }*/
        Method method = clazz.getMethod("methodLog");
        System.out.println(method.getName());

        methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);

        method.setAccessible(true);         // 强制调用
        //method.invoke(reflexDemo);
    }

}
