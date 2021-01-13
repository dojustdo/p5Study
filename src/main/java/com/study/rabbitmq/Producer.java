package com.study.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @className: Consumer
 * @description: MQ 生产者
 * @author: dxq
 * @date: 2021/1/13
 **/
public class Producer {
    private final static String EXCHANGE_NAME = "SIMPLE_EXCHANGE";
    private final static String QUEUE_NAME = "QUEUE_NAME";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 连接ip
        connectionFactory.setHost("127.0.0.1");
        // 默认监听端口
        connectionFactory.setPort(5672);
        // 虚拟机
        connectionFactory.setVirtualHost("/");
        // 设置访问用户
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");

        // 建立连接
        Connection connection = connectionFactory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();

        // 消息
        String msg = "hello world";

        channel.basicPublish(EXCHANGE_NAME, "simple", null, msg.getBytes());
        channel.close();
        connection.close();
    }
}
