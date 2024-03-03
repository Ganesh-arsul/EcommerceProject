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
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cat_id")
	private int catId;
	
	@Column(name ="cat_name")
	private String catName;
	
	@Column(name = "cat_description")
	private String catDesc;
	
	@Lob
	@Column(name = "cat_image")
	private String catImage;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "status")
	private String status;

	@Column(name = "main_cat_id")
	private int mainCatId;

    
}
