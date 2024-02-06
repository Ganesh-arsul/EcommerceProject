package com.c.ecart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

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

	public int getProdId() {
		return ProdId;
	}

	public void setProdId(int prodId) {
		ProdId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCatId() {
		return CatId;
	}

	public void setCatId(int catId) {
		CatId = catId;
	}
	
	
}
