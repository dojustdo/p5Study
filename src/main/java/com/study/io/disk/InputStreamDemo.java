package com.study.io.disk;

import java.io.*;

/**
 * @author dxq
 * @title: InputStreamDemo
 * @projectName reflex
 * @description: 字节输入流
 * @date 2020/2/25 16:01
 */
public class InputStreamDemo {

    // input把磁盘数据读取到内存
    // output把内存数据写到硬盘
    public static void main(String[] args) {
        File file = new File("D:/img.png");
        try (   // java7写法 自动关闭流
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream("D:/img_cp.png")) {
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) != -1) {
                //fileOutputStream.write(len);    // 写到磁盘（多次磁盘交互）
                fileOutputStream.write(buffer, 0, len); //把输入的字节流输出到指定的目录下
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
