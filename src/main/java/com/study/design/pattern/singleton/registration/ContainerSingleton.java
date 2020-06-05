package com.study.design.pattern.singleton.registration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author dxq
 * @title: ContainerSingleton
 * @projectName reflex
 * @description: 注册式单列 容器单例
 * @date 2020/6/5 10:08
 */
public class ContainerSingleton {
    private ContainerSingleton() {

    }

    private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();

    public static Object getInstance(String className) {
        Object instance = null;
        if (!ioc.containsKey(className)) {
            synchronized (ContainerSingleton.class) {
                if (!ioc.containsKey(className)) {
                    try {
                        instance = Class.forName(className).newInstance();
                        ioc.put(className, instance);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            return ioc.get(className);
        }
        return instance;
    }

}
