package com.study.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Generic {

    public static void main(String[] args) throws Exception {
        // demo1();
        // demo2();
        demo3();
    }

    /**
     * 泛型类型在逻辑上可以看作多个类型，实际上是一个类型
     */
    public static void demo1() {
        List a = new ArrayList<String>();
        List b = new ArrayList<Integer>();

        System.out.println(a.getClass());
        System.out.println(b.getClass());
    }


    /**
     * 泛型擦除 泛型只在编译期间有效，运行期间可通过反射改变类型
     */
    public static void demo2() throws Exception {
        ArrayList<String> a = new ArrayList<String>();
        a.add("一个string");
        // 实际长度为一个，且不能add其它类型的对象 a.add(88); 是编译不通过的。
        System.out.println("操作前的长度：" + a.size());

        // 反射改变a的形参类型
        Class clazz = a.getClass();
        Method method = clazz.getDeclaredMethod("add", Object.class);
        method.invoke(a, 12);
        System.out.println("操作后的长度：" + a.size());
    }

    /**
     * 泛型通配符
     */
    public static void demo3() {
        // 无边界都行
        ArrayList<Object> list1 = new ArrayList<>();
        demo3_1(list1);
        ArrayList<String> list2 = new ArrayList<>();
        demo3_1(list2);

        // demo3_2(list1); 上边界报错
        demo3_3(list1); // 下边界报错

    }

    // 无边界
    public static void demo3_1(ArrayList<?> list) {
        return;
    }


    // 上边界
    public static void demo3_2(ArrayList<? extends Number> list) {
        return;
    }

    // 下边界
    public static void demo3_3(ArrayList<? super Number> list) {
        return;
    }
}
