package com.c.ecart.service;

import java.time.LocalDateTime;
import java.util.List;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.Orders;
import com.c.ecart.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders addOrder(Orders order) {
		try {
			
			orderRepository.save(order);
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in addOrder:"+ex.getMessage()+"Cause: "+ex.getCause());
			
		}
		return null;
	}
	public boolean cancelOrder(int orderId) {
		try {
			if(orderRepository.cancelOrder(orderId)<0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ex) {
			System.err.println("Exception Occured in cancelOrder:"+ex.getMessage()+" cause:"+ex.getCause());
		}
		return false;
	}
	
	public List<Orders> getOrders(){
		try {
		return orderRepository.findAll();
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getOrders: "+ex.getMessage()+"cause: "+ex.getCause());
			
		}
		return null;
	}
	public Orders getOrder(int orderId){
		try {
		if(orderId!=0) {
		return orderRepository.findById(orderId).get();
		}
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getOrder: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}
	

}
