package com.study.design.pattern.singleton;

import com.study.design.pattern.singleton.lazy.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author dxq
 * @title: ReflexTest
 * @projectName reflex
 * @description: 反射破坏单列
 * @date 2020/6/4 10:45
 */
public class ReflexTest {
    /**
     * 通过反射破坏单列 任何情况下只有一个实列的原则
     *
     * @param args
     */
    public static void main(String[] args) {
        Class clazz = LazyInnerClassSingleton.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Object o = constructor.newInstance();
            System.out.println(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
