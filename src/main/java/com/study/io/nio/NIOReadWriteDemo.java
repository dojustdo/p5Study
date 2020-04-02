package com.study.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dxq
 * @title: NIOReadWriteDemo
 * @projectName reflex
 * @description: NIO读写操作demo
 * @date 2020/4/2 16:22
 */
public class NIOReadWriteDemo {

    public static void main(String[] args) {
        try (
                FileInputStream fileInputStream = new FileInputStream("E:/test.txt");
                FileOutputStream fileOutputStream = new FileOutputStream("E:/test_cp.txt");
        ) {
            FileChannel fcin = fileInputStream.getChannel();
            FileChannel fcout = fileOutputStream.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(10);

            while (true) {
                int i = fcin.read(byteBuffer);
                // 读取不到任何新byte i==-1
                System.out.println(new String(byteBuffer.array()));
                if (i == -1) {
                    break;
                }
                byteBuffer.flip();
                fcout.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

