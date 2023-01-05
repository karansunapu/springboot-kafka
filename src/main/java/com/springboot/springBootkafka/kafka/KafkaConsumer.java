package com.springboot.springBootkafka.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "karanTopic", groupId = "myGroup")
    public void consumer(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
