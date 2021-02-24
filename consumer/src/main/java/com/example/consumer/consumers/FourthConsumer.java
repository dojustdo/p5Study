package com.example.consumer.consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @className: FirstConsumer
 * @description: 类描述
 * @author: dxq
 * @date: 2021/2/24
 **/
@Component
@PropertySource("classpath:rabbitmq.properties")
@RabbitListener(queues = "${com.rabbitmq.fourthqueue}",containerFactory = "rabbitListenerContainerFactory")
public class FourthConsumer {
    @RabbitHandler
    public void process(String messageContent, Channel channel, Message message) throws IOException {
        System.out.println(messageContent);
        /*System.out.println(messageContent);*/
        // 手动应答
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

}
