package com.example.demo.rmqDemo2;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;

/**
 * 无用--仅用来写注释
 */
public class MyBean {
    /**
     * RabbitMQ系统管理功能组件
     */
    private final AmqpAdmin amqpAdmin;
    /**
     * 给RabbitMq发送和接收消息
     * */
    private final AmqpTemplate amqpTemplate;

    public MyBean(AmqpAdmin amqpAdmin,AmqpTemplate amqpTemplate){
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }
}
