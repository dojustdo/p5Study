package com.study.annotation;

import org.springframework.context.annotation.Bean;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author dxq
 * @title: ioc
 * @projectName reflex
 * @description: 注解ioc容器
 * @date 2019/12/16 18:44
 */
public class Ioc {

    public static void main(String[] args) throws Exception {

        // 装扫描路径下的类集合
        HashSet<String> allClass = new HashSet();

        // 假设ioc容器
        HashMap<String, Object> ioc = new HashMap();

        // 扫描包路径
        doScanner(allClass, "com.study.annotation");

        for (String aClass : allClass) {
            Class clazz = Class.forName(aClass);
            // 构造实列化bean
            if (clazz.isAnnotationPresent(Bean.class)) {
                ioc.put(aClass, clazz.newInstance());
            }

            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {

                if (method.isAnnotationPresent(Bean.class)) {
                    String[] beanName = method.getAnnotation(Bean.class).value();
                    // 静态工厂
                    if (Modifier.isStatic(method.getModifiers())) {
                        ioc.put(beanName[0], method.invoke(null));
                    } else {
                        // 实列工厂
                        ioc.put(beanName[0], method.invoke(clazz.newInstance()));
                    }
                }
            }
        }
    }

    /**
     * 得到包路径下所有class全路径
     *
     * @param allClass
     * @param scannerPackage
     */
    public static void doScanner(HashSet allClass, String scannerPackage) {
        URL url = Ioc.class.getResource("/" + scannerPackage.replaceAll("\\.", "/"));
        File dir = new File(url.getFile());

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(allClass, scannerPackage + "." + file.getName());
            } else {
                //如果文件不是.class结尾
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                //拼装类的全路径
                String className = (scannerPackage + "." + file.getName().replace(".class", ""));
                //添加到集合中
                allClass.add(className);
            }
        }
    }

}
