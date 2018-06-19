package com.quyiwang.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author huangweiyue
 * @Date Created in 2018-06-19 15:39
 * @ModifiedBy
 * @Version v1.0
 */
@Configuration
public class TopicSendConfiguration {

//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new JsonMessageConverter();
//    }
    @Bean(name = "link")
    public Queue queueMessage() {
        return new Queue("insurance.link");
    }

    @Bean(name = "hb")
    public Queue queueMessages() {
        return new Queue("insurance.hb");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    //*表示一个词,#表示零个或多个词
    @Bean
    Binding bindingExchangeMessage(@Qualifier("link") Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("link.*");
    }

    @Bean
    Binding bindingExchangeMessages(@Qualifier("hb") Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("hb.*");
    }

}
