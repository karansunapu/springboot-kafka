package com.springboot.springBootkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Bean
    public NewTopic karanTopic(){
        return TopicBuilder.name("karanTopic")
                .build();
    }

    @Bean
    public NewTopic Json_karanTopic(){
            return TopicBuilder.name("Json_karanTopic")
                .build();
    }
}
