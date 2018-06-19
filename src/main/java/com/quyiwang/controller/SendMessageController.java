package com.quyiwang.controller;

import com.quyiwang.dto.Book;
import com.quyiwang.rabbitmq.HelloSender;
import com.quyiwang.rabbitmq.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangwieyue
 * @date 2018-02-13 11:48
 */
@RestController
@RequestMapping("rabbit")

public class SendMessageController {
    @Autowired
    private HelloSender helloSender;

    @Autowired
    private TopicSender topicSender;

    /**
     * @Description://http://localhost:8096/rabbit/directSend
     * direct模式
     **/

    @GetMapping("/directSend")
    public void directSendMessage() {
        helloSender.send();
    }

    /**
    * @Description:http://localhost:8090/rabbit/topicSend
    **/

    @GetMapping("/topicSend")
    public void topicSendMessage() {

        // 把第二个参数改为topic.messages就只能收到第一条记录了
        try {
            //topicSender.send("topicExchange","link.aaaa","topic模式发送的消息");
            topicSender.send("topicExchange","link.step1",new Book("红楼梦","施耐庵"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}