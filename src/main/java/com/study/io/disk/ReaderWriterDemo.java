package com.study.io.disk;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author dxq
 * @title: ReaderWriterDemo
 * @projectName reflex
 * @description: 字符流demo
 * @date 2020/3/6 15:51
 */
public class ReaderWriterDemo {

    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("D:/test.txt");
             FileWriter fileWriter = new FileWriter("D:/txt.txt")) {

            int len = 0;
            char[] bytes = new char[1024];
            while ((len = fileReader.read(bytes)) != -1) {
                fileWriter.write(bytes,0,len);
            }
        } catch (Exception e) {

        }
    }
}
