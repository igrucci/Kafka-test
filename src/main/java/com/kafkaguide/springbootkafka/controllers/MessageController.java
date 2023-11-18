package com.kafkaguide.springbootkafka.controllers;

import com.kafkaguide.springbootkafka.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

@GetMapping("/publish")
    public ResponseEntity<String>publish(@RequestParam("message") String message){
kafkaProducer.sendMessage(message);
//ResponseEntity<>. Этот объект представляет собой оболочку для Java классов.
// вместо прямого возвращаемого типа данных в контроллере, использовать оболочку ResponseEntity<>
// и возвращать конечному пользователю описание результата действия
return ResponseEntity.ok("Message sent to the topic");
}
}
