package com.example.demo.rmqDemo2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 使用注解方式监听mq
 * @author yali yang
 */
@Service
public class RmqService {

    @RabbitListener(queues = "myQueue1")
    public void receive1(Object obj){
        System.out.println(obj);
    }
}
