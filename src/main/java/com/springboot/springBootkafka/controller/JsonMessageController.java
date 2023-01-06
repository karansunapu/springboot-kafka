package com.springboot.springBootkafka.controller;


import com.springboot.springBootkafka.kafka.JsonKafkaProducer;
import com.springboot.springBootkafka.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer jsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    // http://localhost:8080/api/v1/kafka/publish -> with Json payload
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        jsonKafkaProducer.publishJsonMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}
