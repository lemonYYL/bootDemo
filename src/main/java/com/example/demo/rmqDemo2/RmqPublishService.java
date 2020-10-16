package com.example.demo.rmqDemo2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息发送service
 * @author yali yang
 */
@Service
public class RmqPublishService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void publish(){
        Map<String,Object> map = new HashMap<>();
        map.put("first","firstOne");
        map.put("second",false);
        map.put("third",1234);
        rabbitTemplate.convertAndSend("my.fanout",null,map);
    }
}
