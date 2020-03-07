package com.infy.camelrestdsl.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.infy.camelrestdsl.dto.Order;

@Service
public class OrderService {
	private List<Order> orderList=new ArrayList<Order>();
	
	@PostConstruct
	public void initDB() {
			orderList.add(new Order(1,"Mobile"));
			orderList.add(new Order(2,"TV"));
	}
	
	public Order addOrder(Order order) {
		orderList.add(order);
		return order;
	}
	
	public List<Order> getOrders(){
		return orderList;
	}
	

}
