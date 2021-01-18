package com.study.rabbitmq;

import com.rabbitmq.client.*;
import com.rabbitmq.client.Consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

        // 指定队列的死信交换机, 消费者一直不获取交换机中的消息，消息就会发送到死信交换机，死信队列
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "DLX_EXCHANGE");
        // 设置队列的ttl
        arguments.put("x-expires", "9000");
        // 设置队列的最大长度，超过长度，先进入队列的进入死信队列
        arguments.put("x-max-length", 4);

        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", false, false, null);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 绑定队列和交换机
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "simple");

        // 声明死信交换机
        channel.exchangeDeclare("DLX_EXCHANGE", "topic", false, false, null);
        // 声明死信队列
        channel.queueDeclare("DLX_QUEUE", false, false, false, null);

        // 绑定死信队列和交换机
        channel.queueBind("DLX_QUEUE", "DLX_EXCHANGE", "#");

        // 创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                System.out.printf(msg);
            }
        };
        // 开始获取消息
        // channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
