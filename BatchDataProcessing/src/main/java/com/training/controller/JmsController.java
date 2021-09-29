package com.training.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Product;

@RestController
public class JmsController {
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("/mq/publish/{message}")
	public String publish(@PathVariable("message") String message) {
		
		jmsTemplate.convertAndSend(queue,message);
		return message+" published.";
	}
	
	@PostMapping("/mq/publishproduct")
	public Product publishedProduct(@RequestBody Product product) {
		
		jmsTemplate.convertAndSend(queue,product);
		return product;
	}
	
}
