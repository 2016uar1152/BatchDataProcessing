package com.training.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.FailedProduct;
import com.training.bean.Product;

@RestController
@RequestMapping("/")
public class JmsController {
	
	@Autowired
	private ActiveMQQueue queue;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@GetMapping("")
	public String welcome() {
		return "Hello, Product Manager/Owner.";
	}
	
	@PostMapping("/")
	public FailedProduct publishedProduct(@RequestBody FailedProduct failedProduct) {
		
		jmsTemplate.convertAndSend(queue,failedProduct);
		return failedProduct;
	}
	
}
