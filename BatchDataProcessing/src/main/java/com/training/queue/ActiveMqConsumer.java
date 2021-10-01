package com.training.queue;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.bean.FailedProduct;

@Component
public class ActiveMqConsumer {
	
	public static List<FailedProduct> list = new ArrayList<FailedProduct>();
	
	@JmsListener(destination = "ProductQueue" )
	public void listener(FailedProduct failedProduct){
		list.add(failedProduct);
	}
	
	public void processFailedProducts(List<FailedProduct> list){
		String[] messageArray = {"", "UPC can't be empty!!", "Code for Artist ID cannot be empty or have more than 7 digits.",
				"Code for Organisation ID cannot be empty or more than 8 digits.","Release Date format is incorrect. Only YYYYMMDD allowed.",
				"Release Date must have 8 digits."};
		for(FailedProduct failedProduct: list) {
			String message=messageArray[failedProduct.getMessageId()];
			
			//send to ui for modification with message
			//after modification reprocess the failed product
		}
		
	}
	
	
	
	
}