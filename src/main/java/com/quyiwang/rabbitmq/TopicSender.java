package com.quyiwang.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author huangweiyue
 * @Date Created in 2018-06-19 15:54
 * @ModifiedBy
 * @Version v1.0
 */
@Component
public class TopicSender {
    /**
     * 消息队列模板
     */
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //第一个参数是交换机名称,第二个参数是发送的key,第三个参数是内容
    public void send(String exchangeName, String routingKey,Object message) throws Exception {
        //发送消息到消息队列
        rabbitTemplate.convertAndSend(exchangeName,routingKey,message);
    }
}
