package com.kafka.kafkademo.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.kafka.kafkademo.processor.MessageBodyLogger;
import com.kafka.kafkademo.properties.KafkaConfigurationProperties;

@Component
@EnableConfigurationProperties(value = KafkaConfigurationProperties.class)
public class TestRoute extends RouteBuilder {

	private final KafkaConfigurationProperties kafkaConfigurationProperties;
	private final MessageBodyLogger messageBodyLogger;

    public TestRoute(KafkaConfigurationProperties kafkaConfigurationProperties, MessageBodyLogger messageBodyLogger){
        this.kafkaConfigurationProperties = kafkaConfigurationProperties;
        this.messageBodyLogger = messageBodyLogger;
    }

	@Override
	public void configure() {
		from("kafka:" + kafkaConfigurationProperties.topicName()).process(messageBodyLogger).end();
	}

}