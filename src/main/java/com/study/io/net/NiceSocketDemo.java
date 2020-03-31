package com.study.io.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dxq
 * @title: SocketDemo
 * @projectName reflex
 * @description: 网络io通信
 * @date 2020/3/10 17:25
 */
public class NiceSocketDemo {

    public static final int DEFAULT_PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", DEFAULT_PORT)) {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("呼叫总部，呼叫总部\n");
            bufferedWriter.flush();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("收到服务端消息：" + bufferedReader.readLine());
        }

    }

    static class ServerSocketDemo {

        public static void main(String[] args) {
            try {
                // 服务端绑定一个监听端口
                ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
                ExecutorService executorService = Executors.newFixedThreadPool(5);
                while (true) {
                    // 阻塞操作 等待客户端连接
                    Socket socket = serverSocket.accept();
                    executorService.submit(new Thread(() -> {
                        try {
                            Thread.sleep(15000);
                            System.out.println("客户端：" + socket.getPort() + "已连接");
                            // 获得客户端输入的信息
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                            System.out.println("收到客户端消息:" + bufferedReader.readLine());
                            // 回复客户端消息
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                            bufferedWriter.write("收到收到，over\n");
                            bufferedWriter.flush();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
