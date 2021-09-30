package com.training.queue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.training.bean.FailedProduct;

//@Component
public class ActiveMqConsumer {
    
	public static List<FailedProduct> list = new ArrayList<FailedProduct>();
	
	//@JmsListener(destination = "ProductQueue")
	public void listener(FailedProduct failedProduct){
		list.add(failedProduct);
	}
	
	public void processFailedProducts(List<FailedProduct> list){
		for(FailedProduct failedProduct: list) {
			int messageId = failedProduct.getMessageId();
			String message="";
			if(messageId==1)
			{
				message="UPC can't be empty!!";
			}
			else if(messageId==2)
			{
				message="Code for Artist ID cannot be empty or have more than 7 digits.";
			}
			else if(messageId==3)
			{
				message="Code for Organisation ID cannot be empty or more than 8 digits.";
			}
			else if(messageId==4)
			{
				message="Release Date format is incorrect. Only YYYYMMDD allowed.";
			}
			else if(messageId==5)
			{
				message="Release Date must have 8 digits.";
			}
			//send to ui for modification with message
			//after modification reprocess the failed product
		}
		
	}
	
	
}