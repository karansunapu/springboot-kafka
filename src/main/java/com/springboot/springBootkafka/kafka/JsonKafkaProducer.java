package com.springboot.springBootkafka.kafka;

import com.springboot.springBootkafka.payload.User;
import org.apache.kafka.common.header.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishJsonMessage(User user){
        Message<User> message = MessageBuilder
                        .withPayload(user)
                        .setHeader(KafkaHeaders.TOPIC, "Json_karanTopic")
                        .build();

        kafkaTemplate.send(message);

        LOGGER.info("published JsonMessage -> "+ user.toString());
    }
}
