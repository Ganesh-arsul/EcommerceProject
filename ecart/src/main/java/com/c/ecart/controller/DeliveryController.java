package com.c.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c.ecart.model.Delivery;
import com.c.ecart.service.DeliveryService;

@RestController
public class DeliveryController {
	
	@Autowired 
	private DeliveryService deliveryService;
	
	@PostMapping("/add-delivery")
	public Delivery addDelivery(@RequestBody Delivery delivery) {
		return deliveryService.addDelivery(delivery);
	}
	

}
