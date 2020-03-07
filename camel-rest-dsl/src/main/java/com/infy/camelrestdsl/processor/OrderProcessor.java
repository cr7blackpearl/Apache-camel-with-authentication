package com.infy.camelrestdsl.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infy.camelrestdsl.dto.Order;
import com.infy.camelrestdsl.dto.Student;
import com.infy.camelrestdsl.service.OrderService;

@Component
public class OrderProcessor implements Processor{

	@Autowired
	private OrderService orderService;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		Student stud=new Student();
		//stud.setAddress();
		orderService.addOrder(exchange.getIn().getBody(Order.class));
		
	}

}
