package com.study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author dxq
 * @title: SocketChannel
 * @projectName reflex
 * @description: NIO 非阻塞网络IO通信
 * @date 2020/4/4 17:56
 */
public class ServerSocketChannelDemo {

    public static void main(String[] args) {
        // 可以支持两种模式，阻塞 和 非阻塞
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8080));
            while (true) {
                // 判断有无socketChannel有无连接
                SocketChannel socketChannel = serverSocketChannel.accept(); // 仍然是阻塞的
                if (socketChannel != null) {
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    socketChannel.read(byteBuffer);
                    System.out.println(new String(byteBuffer.array()));

                    byteBuffer.clear();
                    byteBuffer.put("hello socketChannel".getBytes());
                    byteBuffer.flip();
                    socketChannel.write(byteBuffer);
                } else {
                    Thread.sleep(1000);
                    System.out.println("暂无客户端连接");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class SocketChannelDemo {
        public static void main(String[] args) {
            try (SocketChannel socketChannel = SocketChannel.open()) {
                socketChannel.configureBlocking(false);
                // 在非阻塞情况下，这段代码不一定是等到连接建立后再往下执行。
                socketChannel.connect(new InetSocketAddress("localhost", 8080));
                // 所以非阻塞下加这段代码
                if (socketChannel.isConnectionPending()) {
                    socketChannel.finishConnect();
                }
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                byteBuffer.put("hello ServerSocketChannel".getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);

                // 由写到读
                byteBuffer.clear();
                while (true) {
                    int r = socketChannel.read(byteBuffer);
                    if (r > 0) {
                        System.out.println("收到服务端数据" + new String(byteBuffer.array()));
                    } else {
                        Thread.sleep(1000);
                        System.out.println("未收到服务端数据");
                    }
                }
                // 保持线程连接
                //System.in.read();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
