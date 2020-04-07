package com.study.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author dxq
 * @title: ZeroCopyDemo
 * @projectName reflex
 * @description: NIO通信零拷贝
 * @date 2020/4/7 14:45
 */
public class ZeroCopyDemo {

    public static void main(String[] args) {
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
             FileChannel fileChannel = new FileOutputStream("E:/test_nio_cp.txt").getChannel()) {
            serverSocketChannel.bind(new InetSocketAddress(8080));
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
            int read = 0;
            while (read != -1) {
                // 将字节流读入缓冲区
                read = socketChannel.read(byteBuffer);
            }
            byteBuffer.flip();
            fileChannel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ZeroCopyClientDemo {

        public static void main(String[] args) {
            try (SocketChannel socketChannel = SocketChannel.open();
                 FileChannel fileChannel = new FileInputStream("E:/test.txt").getChannel()) {
                socketChannel.connect(new InetSocketAddress("localhost", 8080));
                long position = 0;
                long size = fileChannel.size();
                while (size > 0) {
                    // 一次最多发送8M t为总的数据传输字节数
                    long t = fileChannel.transferTo(position, size, socketChannel);
                    System.out.println("总传输数据字节数" + t);
                    position += t;
                    size -= t;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
