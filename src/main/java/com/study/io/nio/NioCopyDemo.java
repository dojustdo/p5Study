package com.study.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dxq
 * @title: NioDemo
 * @projectName reflex
 * @description: NIO 实现文件复制
 * @date 2020/3/31 17:02
 */
public class NioCopyDemo {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("E:/test.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("E:/test_cp.txt");

            FileChannel fin = fileInputStream.getChannel();
            FileChannel fout = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fin.read(byteBuffer);
            byteBuffer.flip();
            fout.write(byteBuffer);
            byteBuffer.clear();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
