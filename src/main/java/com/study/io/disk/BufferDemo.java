package com.study.io.disk;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author dxq
 * @title: BufferDemo
 * @projectName reflex
 * @description: 缓冲流demo  缓冲流的性能更好
 * @date 2020/3/6 15:19
 */
public class BufferDemo {

    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(new FileInputStream("D:/test.txt"));
             BufferedOutputStream bufferedOutputStream =
                     new BufferedOutputStream(new FileOutputStream("D:/test1.txt"))) {
            int len = 0;
            byte[] bys = new byte[1024];
            while ((len = bufferedInputStream.read(bys)) != -1) {
                System.out.println(new String(bys,0,len));
                bufferedOutputStream.write(bys,0,len);
                bufferedOutputStream.flush(); // 刷盘动作，把缓存里的数据写到硬盘
            }
        } catch (Exception e) {

        }
    }

}
