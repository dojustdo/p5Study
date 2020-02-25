package com.study.io.disk;


import java.io.FileInputStream;

/**
 * @author dxq
 * @title: ReadDemo
 * @projectName reflex
 * @description: 字节流read方法应用
 * @date 2020/2/25 16:35
 */
public class ReadDemo {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("D:/gitProject/text.txt")
        ) {
            int len = 0;
            byte[] buffer = new byte[3]; // 占用内存空间
            while ((len = fileInputStream.read(buffer)) != -1) {
                // 这个列子中增加了buffer后 从与磁盘交互11次变成了4次
                //System.out.println((char)len);
                System.out.println(new String(buffer, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
