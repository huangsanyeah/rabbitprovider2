package com.quyiwang.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author huangweiyue
 * @Date Created in 2018-06-18 17:50
 * @ModifiedBy
 * @Version v1.0
 */
@Configuration
public class SenderConf {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
}
