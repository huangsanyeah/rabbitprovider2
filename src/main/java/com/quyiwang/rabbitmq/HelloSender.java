package com.quyiwang.rabbitmq;

import com.quyiwang.dto.Book;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author huangweiyue
 * @Date Created in 2018-06-18 17:51
 * @ModifiedBy
 * @Version v1.0
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    public void send() {
        Book book=new Book("西游记","吴承恩");
        template.convertAndSend("queue",book);
    }
}
