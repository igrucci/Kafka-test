package com.kafkaguide.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    //регитсратор для регистрации сообщений
    private static final Logger LOGGER = LoggerFactory.getLogger((KafkaConsumer.class));

    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consume(String message){
        //вывод в консоль
 LOGGER.info(String.format("Message recieved -> %s", message));
    }
}
