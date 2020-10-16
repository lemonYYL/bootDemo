package com.example.demo;

import com.example.demo.entity.YmlDemoBean;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    YmlDemoBean bean;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void contextLoads() {
        System.out.println(bean);
    }


    @Test
    void admin(){
        //消息配置
        //配置转换器
        amqpAdmin.declareExchange(new DirectExchange("admin.exchange"));
        //配置队列
        amqpAdmin.declareQueue(new Queue("myQueue"));
        //配置binding
        amqpAdmin.declareBinding(new Binding("myQueue", Binding.DestinationType.QUEUE,"admin.exchange","beautiful",null));
    }


    /**
     * 一对一 单播
     */
    @Test
    void publish(){
        //发送消息
     /*   //消息体
        byte[] body = "messageBody lalalallalal".getBytes();
        Message msg = new Message(body,new MessageProperties());
        rabbitTemplate.send("admin.exchange","beautiful",msg);*/

        Map<String,Object> map = new HashMap<>();
        map.put("first","idea");
        map.put("second",false);
        rabbitTemplate.convertAndSend("admin.exchange","beautiful",map);
        logger.info("发送消息成功！消息体：{}",map);
    }

    @Test
    void receive(){
        //接收消息
        Object obj = rabbitTemplate.receiveAndConvert("myQueue");
        logger.info("消息接收成功，消息：{}",obj);
    }

    @Test
    void addFanoutExchange(){
        //增加fanout转换器
        amqpAdmin.declareExchange(new FanoutExchange("my.fanout"));
        logger.info("增加fanout转换器成功！");
    }

    @Test
    void addQueue(){
        //增加队列1
        amqpAdmin.declareQueue(new Queue("myQueue1"));
        //增加队列2
        amqpAdmin.declareQueue(new Queue("myQueue2"));
        //增加队列3
        amqpAdmin.declareQueue(new Queue("myQueue3"));
        logger.info("增加队列成功！");
    }

    @Test
    void fanoutQueueConfig(){
        //为fanout 配置binding
        amqpAdmin.declareBinding(new Binding("myQueue1", Binding.DestinationType.QUEUE,"my.fanout","",null));
        amqpAdmin.declareBinding(new Binding("myQueue2", Binding.DestinationType.QUEUE,"my.fanout","",null));
        amqpAdmin.declareBinding(new Binding("myQueue3", Binding.DestinationType.QUEUE,"my.fanout","",null));
    }

    /**
     * 广播
     */
    @Test
    void broadcast(){
        Map<String,Object> map = new HashMap<>();
        map.put("first","idea");
        map.put("second",false);
        rabbitTemplate.convertAndSend("my.fanout",null,map);
    }

}
