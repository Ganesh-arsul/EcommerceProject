package com.c.ecart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name = "items")
	private String items;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "status")
	private String status;

}
