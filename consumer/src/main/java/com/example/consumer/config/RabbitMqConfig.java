package com.example.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @className: RabbitMqConfig
 * @description: rabbitMq配置类
 * @author: dxq
 * @date: 2021/2/24
 **/
@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitMqConfig {
    @Value("DIRECT_EXCHANGE")
    private String directExchange;

    @Value("TOPIC_EXCHANGE")
    private String topicExchange;

    @Value("FANOUT_EXCHANGE")
    private String fanoutExchange;

    @Value("FIRST_QUEUE")
    private String firstQueue;

    @Value("SECOND_QUEUE")
    private String secondQueue;

    @Value("THIRD_QUEUE")
    private String thirdQueue;

    @Value("FOURTH_QUEUE")
    private String fourthQueue;

    // 创建四个队列
    @Bean("firstQueue")
    public Queue getFirstQueue() {
        return new Queue(firstQueue);
    }

    @Bean("secondQueue")
    public Queue getSecondQueue() {
        return new Queue(secondQueue);
    }

    @Bean("thirdQueue")
    public Queue getThirdQueue() {
        return new Queue(thirdQueue);
    }

    @Bean("fourthQueue")
    public Queue getFourthQueue() {
        return new Queue(fourthQueue);
    }

    // 创建三个交换机
    @Bean("directExchange")
    public DirectExchange getDirectExchange() {
        return new DirectExchange(directExchange);
    }

    @Bean("topicExchange")
    public TopicExchange getTopicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    // 定义四个绑定关系
    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue, @Qualifier("directExchange") DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("demo.best");
    }

    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue, @Qualifier("topicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.demo.*");
    }

    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindFourth(@Qualifier("fourthQueue") Queue queue, @Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        factory.setAutoStartup(true);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

}
