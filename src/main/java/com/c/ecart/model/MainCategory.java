package com.c.ecart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "main_category")
public class MainCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "main_cat_id")
	private int maincatId;
	
	@Column(name ="cat_name")
	private String catName;
	
	@Column(name = "cat_description")
	private String catDesc;
	
	@Column(name = "status")
	private String status;

	public int getMaincatId() {
		return maincatId;
	}

	public void setMaincatId(int maincatId) {
		this.maincatId = maincatId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
