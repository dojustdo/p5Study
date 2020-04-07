package com.study.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author dxq
 * @title: SelectorDemo
 * @projectName reflex
 * @description: 选择器（多路复用器）
 * @date 2020/4/6 17:30
 */
public class SelectorDemo {

    static Selector selector;

    public static void main(String[] args) throws IOException {
        // 创建一个多路复用器
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 必须设置为非阻塞状态，才能交给多路复用器
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8080));
        // 注册 op_accept监听连接事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            // 阻塞 直到有注册的事件
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 避免重复处理
                iterator.remove();
                if (selectionKey.isAcceptable()) { // 连接事件
                    acceptHandle(selectionKey);
                } else if (selectionKey.isReadable()) {// 读事件
                    readHandle(selectionKey);
                }
            }
        }
    }

    public static void acceptHandle(SelectionKey selectionKey) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        // 一定不会为空，一定是有连接过来才会进这里
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 设置io的非阻塞
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("hello i'm nio ServerSocket".getBytes()));
        // 再注册读的socketChannel读的事件
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    public static void readHandle(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        System.out.println("serverMsg:" + new String(byteBuffer.array()));
    }


    // 客户端
    static class SelectorClient {
        public static void main(String[] args) throws IOException {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8080));
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    // 避免重复处理
                    iterator.remove();
                    if (selectionKey.isConnectable()) { // 连接事件
                        connectionHandle(selectionKey);
                    } else if (selectionKey.isReadable()) {// 读事件
                        clientReadHandle(selectionKey);
                    }
                }
            }
        }

        public static void connectionHandle(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            if (socketChannel.isConnectionPending()) {
                socketChannel.finishConnect();
            }
            socketChannel.write(ByteBuffer.wrap("hello i'm nio socket".getBytes()));
            socketChannel.register(selector, SelectionKey.OP_READ);
        }

        public static void clientReadHandle(SelectionKey selectionKey) throws IOException {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            socketChannel.read(byteBuffer);
            System.out.println("clientMsg:" + new String(byteBuffer.array()));
        }
    }

}
