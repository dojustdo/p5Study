package com.study.io.disk;

import java.io.*;

/**
 * @author dxq
 * @title: FileInputStreamDemo
 * @projectName reflex
 * @description: 文件输入流demo
 * @date 2020/2/10 12:01
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        // 读取本地磁盘 固定写法
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/gitProject/text.txt");
            int i = 0;
            // -1 代表字节读取结束
            while ((i = fileInputStream.read()) != -1) {
                System.out.print(String.valueOf((char) i));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
