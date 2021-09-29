package com.training.bean;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

public class ActiveMqProducer {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Bean
	public void publishProduct(FailedProduct failedProduct) {
		jmsTemplate.convertAndSend(queue,failedProduct);
	}
	
	
	
}
