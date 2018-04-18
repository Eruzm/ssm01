package com.fglife.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.fglife.model.Order;
import com.fglife.service.OrderService;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction implements ModelDriven<Order> {

	private static final Logger LOG = LogManager.getLogger(OrderAction.class
			.getName());

	private Order order;

	private List<Order> orders = new ArrayList<Order>();

	@Autowired
	private OrderService orderService;

	@Action(value = "index", results = { @Result(name = "success", location = "order.jsp") })
	public String index() {
		orders = orderService.getAllOrders();
		return "success";
	}

	@Action(value = "editOrder", results = { @Result(name = "success", location = "editOrder.jsp") })
	public String editOrder() {

		return "success";
	}

	@Action(value = "saveOrder", results = { @Result(name = "success", location = "index", type = "redirect") })
	public String saveOrder() {

		try {
			if ( StringUtils.isEmpty( order.getOrderNo()) ) {
				orderService.createOrder(order);
				LOG.info("Created new Order: " + order);
			} else {
				orderService.updateOrder(order);
				LOG.info("Updated Order: " + order);
			}

			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
	}

	@Action(value = "deleteOrder", results = {
			@Result(name = "success", location = "index", type = "redirect"),
			@Result(name = "fail", location = "fail.jsp") })
	public String deleteOrder() {

		try {
			orderService.deleteOrder(order.getOrderNo());

			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "fail";
		}
	}

	@Override
	public Order getModel() {
		return order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
