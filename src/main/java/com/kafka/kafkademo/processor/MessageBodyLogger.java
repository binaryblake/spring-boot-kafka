package com.kafka.kafkademo.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class MessageBodyLogger implements Processor {
    @Override
	public void process(Exchange exchange) throws Exception {
		log(exchange.getMessage().getBody());
	}

	private void log(final Object messageBody) {
		System.out.println(messageBody);
	}
}
