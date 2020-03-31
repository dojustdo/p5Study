package com.study.io.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dxq
 * @title: socketDemo
 * @projectName reflex
 * @description: 网络io通信
 * @date 2020/3/10 16:28
 */
public class SimpleSocketDemo {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("它来了，它来了，它迈着步伐走来了".getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }

    static class ServerSocketDemo {
        public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(8080);
            // 阻塞 等待一个客户端的连接
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, len, "UTF-8"));
            }
            inputStream.close();
            socket.close();
        }
    }
}
