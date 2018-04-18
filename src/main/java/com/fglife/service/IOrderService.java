package com.fglife.service;

import java.sql.Date;
import java.util.List;

import com.fglife.model.Order;

public interface IOrderService {

	public List<Order> getAllOrders();

	public void createOrder(Order order);

	public void deleteOrder(String orderNo);

	public void updateOrder(Order order);

	Order getOrder(int i, String clientId, double d, Date tranDate);

}
