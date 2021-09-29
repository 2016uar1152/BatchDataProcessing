package com.training.bean;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMqConsumer {
    
	@JmsListener(destination = "ProductQueue")
	public void listener(FailedProduct failedProduct){
		System.out.println("Received Products: " + failedProduct);
		
	}
	
    
}