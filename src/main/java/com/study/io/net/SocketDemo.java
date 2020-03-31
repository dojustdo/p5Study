package com.study.io.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author dxq
 * @title: SocketDemo
 * @projectName reflex
 * @description: 网络io通信
 * @date 2020/3/10 17:25
 */
public class SocketDemo {

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
                // 阻塞操作 等待客户端连接
                // 这一种处理方式是迭代型服务，只能按照客户端顺序一个一个的处理客户端的消息,效率低实用性很差
                Socket socket = serverSocket.accept();
                System.out.println("客户端：" + socket.getPort() + "已连接");
                // 获得客户端输入的信息
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("收到客户端消息:" + bufferedReader.readLine());
                // 回复客户端消息
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write("收到收到，over\n");
                bufferedWriter.flush();
                //socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
