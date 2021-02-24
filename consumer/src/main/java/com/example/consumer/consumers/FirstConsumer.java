package com.example.consumer.consumers;

import com.rabbitmq.client.Channel;
import com.study.rabbitmq.Merchant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.Payload;
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
@RabbitListener(queues = "${com.rabbitmq.firstqueue}",containerFactory = "rabbitListenerContainerFactory")
public class FirstConsumer {
    @RabbitHandler
    public void process(@Payload Merchant merchant, Channel channel, Message message) throws IOException {
        System.out.println(merchant.getName());
        /*System.out.println(messageContent);*/
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

}
