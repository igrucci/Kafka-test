package com.kafkaguide.springbootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducer {
    //регистратор сообщений по умолчанию
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

//частный шаблон кафка
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent %s", message));
        kafkaTemplate.send("javaguides", message);
    }
}
