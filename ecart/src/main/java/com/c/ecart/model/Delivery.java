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
@Table(name = "delivery")
public class Delivery {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "delivery_id")
	private int deliveryId;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "delivery_date")
	private String deliveryDate;
	
	@Column(name = "status")
	private String status;

}
