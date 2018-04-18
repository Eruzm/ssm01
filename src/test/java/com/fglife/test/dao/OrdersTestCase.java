package com.fglife.test.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fglife.model.Order;
import com.fglife.service.OrderService;

public class OrdersTestCase {

	private static ApplicationContext cxt;
	private static OrderService service;
    
	@Before
	public void setUp() {
		 cxt = new ClassPathXmlApplicationContext("spring.xml");
		 service = (OrderService) cxt.getBean("orderService");
	}

	@After
	public void tearDown() {
		
	}

	@Test
	public void testForgetAllOrders() {
		
		List<Order> orders = service.getAllOrders();
		
		Assert.assertNotNull(orders);
		
		
	}

}
