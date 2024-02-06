package com.c.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c.ecart.model.Orders;
import com.c.ecart.service.OrderService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/add-order")
	public Orders addOrder(@RequestBody Orders order) {
	 return orderService.addOrder(order);
	}
	@GetMapping("cancel-order/{orderId}")
	public boolean cancelOrder(@PathVariable("orderId") int orderId) {
		return orderService.cancelOrder(orderId);
	}
	@GetMapping("/orders")
	public List<Orders> getOrders() {
		return orderService.getOrders();
	}
	@GetMapping("/order/{orderId}")
	public Orders getOrder(@PathVariable("orderId") int orderId) {
		return orderService.getOrder(orderId);
	}
	
}
