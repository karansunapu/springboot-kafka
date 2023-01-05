package com.springboot.springBootkafka.controller;

import com.springboot.springBootkafka.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // http:localhost:8080/api/v1/kafka/publish?messaage=message published
    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("messaage") String messsage){
        kafkaProducer.sendMessage(messsage);
        return ResponseEntity.ok("Sent Message to topic");
    }
}
