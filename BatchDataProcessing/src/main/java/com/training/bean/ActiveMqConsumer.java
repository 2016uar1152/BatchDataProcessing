package com.training.bean;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqConsumer {
    
	@JmsListener(destination = "TestQueue")
	public void listener(Product product){
		System.out.println("Received Products: " + product);
		
	}
	
    
}