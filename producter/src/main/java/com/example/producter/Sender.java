package com.example.producter;

import com.fasterxml.jackson.core.io.JsonEOFException;
import com.study.rabbitmq.Merchant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @className: Sender
 * @description: 类描述
 * @author: dxq
 * @date: 2021/2/24
 **/
@Component
@PropertySource("classpath:rabbitmq.properties")
public class Sender {
    @Value("DIRECT_EXCHANGE")
    private String directExchange;

    @Value("TOPIC_EXCHANGE")
    private String topicExchange;

    @Value("FANOUT_EXCHANGE")
    private String fanoutExchange;

    @Value("demo.best")
    private String directRoutingKey;

    @Value("demo1.demo.first")
    private String topicRoutingKey1;

    @Value("demo2.demo.second")
    private String topicRoutingKey2;

    @Autowired
    private AmqpTemplate demoTemplate;

    public void send(){
        Merchant merchant = new Merchant("第一个生产者对象消息");
        demoTemplate.convertAndSend(directExchange,directRoutingKey,merchant);

        demoTemplate.convertAndSend(topicExchange,topicRoutingKey1,"topicMessage -----");
        demoTemplate.convertAndSend(topicExchange,topicRoutingKey2,"topiceMessage -----2");

        demoTemplate.convertAndSend(fanoutExchange,"","fanoutMessage -----");
    }


}
