package com.kafka.kafkademo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.kafka.kafkademo")
public record KafkaConfigurationProperties(String topicName) {
}