package com.springboot.springBootkafka.kafka;

import com.springboot.springBootkafka.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "Json_karanTopic", groupId = "myGroup")
    public void consumeJson(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
    }
}
