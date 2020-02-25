package com.study.io.disk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author dxq
 * @title: MemoryDemo
 * @projectName reflex
 * @description: 内存的字节输入输出流实战
 * @date 2020/2/25 16:49
 */
public class MemoryDemo {

    public static String str = "hello world";

    public static void main(String[] args) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while ((i = byteArrayInputStream.read()) != -1) {
            char c = (char) i;
            byteArrayOutputStream.write(Character.toUpperCase(c));
        }
        System.out.println(byteArrayOutputStream);
    }
}
