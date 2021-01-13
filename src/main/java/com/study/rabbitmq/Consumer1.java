package com.study.rabbitmq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.Consumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @className: Consumer1
 * @description: MQ 消费者
 * @author: dxq
 * @date: 2021/1/13
 **/
public class Consumer1 {
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

        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", false, false, null);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "simple");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.printf(msg);
            }
        };
        // 开始获取消息
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
