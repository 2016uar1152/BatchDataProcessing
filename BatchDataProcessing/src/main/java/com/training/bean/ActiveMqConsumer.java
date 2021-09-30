package com.training.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqConsumer {
    
	//public List<FailedProduct> list = new ArrayList<FailedProduct>();
	
	@JmsListener(destination = "ProductQueue")
	public void listener(FailedProduct failedProduct){
		System.out.println("Received Products: " + failedProduct);
		
		
		
	}
	
	
	
}