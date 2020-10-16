package com.example.demo.rmqDemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/***
 * rabbitmq 生产者  直接使用测试
 * @author yali yang
 */
public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("guest");
        factory.setPassword("guest");
        //设置 RabbitMq 地址
        factory.setHost("localhost");
        //建立到代理服务器的连接
        Connection conn = factory.newConnection();
        //获得信道
        Channel channel = conn.createChannel();
        //声明交换器
        String exchangeDeclare = "hello-exchange";
        channel.exchangeDeclare(exchangeDeclare,"direct",true);

        String  routingkey = "hola";
        //发布消息
        byte[] messageBodyBytes = "quit eating".getBytes();
        channel.basicPublish(exchangeDeclare,routingkey,null,messageBodyBytes);

        channel.close();
        conn.close();
    }
}
