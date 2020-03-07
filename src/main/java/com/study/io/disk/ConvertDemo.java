package com.study.io.disk;

import java.io.*;

/**
 * @author dxq
 * @title: ConvertDemo
 * @projectName reflex
 * @description: 字节流转换为字符流
 * @date 2020/3/6 15:58
 */
public class ConvertDemo {

    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream =
                     new BufferedInputStream(new FileInputStream("D:/test.txt"));
             InputStreamReader inputStreamReader =
                     new InputStreamReader(bufferedInputStream, "utf-8");
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            System.out.println(bufferedReader.readLine());
            /*int len = 0;
            char[] chars = new char[1024];
            while ((len = bufferedReader.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }*/
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(new FileOutputStream("D:/txt.txt"), "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("你好少侠");
            bufferedWriter.flush();
        } catch (Exception e) {

        }
    }

}
