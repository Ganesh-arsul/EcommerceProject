package com.c.ecart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prod_id")
	private int ProdId;
	
	@Column(name = "prod_name")
	private String prodName;
	
	@Column(name = "prod_description")
	private String prodDesc;
	
	@Lob
	@Column(name = "prod_img")
	private String prodImg;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "Prod_price")
	private double prodPrice;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "cat_id")
	private int CatId;

}
