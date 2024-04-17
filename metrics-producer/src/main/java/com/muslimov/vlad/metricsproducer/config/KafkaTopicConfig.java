package com.muslimov.vlad.metricsproducer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic() {
        return TopicBuilder
            .name("metrics-topic")
            .partitions(1)
            .replicas(1)
            .build();
    }

    @Bean
    public NewTopic dlt() {
        return TopicBuilder
            .name("metrics-topic.DLT")
            .partitions(1)
            .replicas(1)
            .build();
    }
}
