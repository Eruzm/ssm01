package com.fglife.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fglife.dao.IOrderDAO;
import com.fglife.model.Order;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderDAO orderDao;

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}

	@Override
	public Order getOrder(int i, String clientId, double d,
			Date tranDate) {
		// TODO Auto-generated method stub
		return orderDao.getOrder(i, clientId, d, tranDate);
	}

	@Override
	public void createOrder(Order order) {
		// TODO Auto-generated method stub
		try {
			orderDao.createOrder(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(String orderNo) {
		try {
			orderDao.deleteOrder(orderNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Order order) {
		try {
			orderDao.updateUser(order);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
