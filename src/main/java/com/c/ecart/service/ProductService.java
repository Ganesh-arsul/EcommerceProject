package com.c.ecart.service;

import java.awt.event.FocusEvent.Cause;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.Products;
import com.c.ecart.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	/*
	 * insert & Update
	 */
	public Products addProduct(Products products) {
		try {
		return productRepository.save(products);
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in addProduct:"+ex.getMessage()+" cause:"+ex.getCause());
		}
		return null;
	}
	
	public boolean removeProduct(int productId) {
		try {
		productRepository.deleteById(productId);
		return true;
		}
		catch(Exception ex) {
			System.err.println("Exception Occured in removeProduct: "+ex.getMessage()+"cause: "+ex.getCause());
		}return false;
	}public List<Products> getProducts(){
		try {
			return productRepository.findAll();
			}
		catch (Exception ex) {
			System.err.println("Exception Occured in getProducts:"+ex.getMessage()+"cause:"+ex.getCause());
		}
		return null;
	}
	public Products getProduct(int productId) {
		try {
			return productRepository.findById(productId).get();
		}
		catch (Exception ex) {
			System. err.println("Exception Occured in getProduct: "+ex.getMessage()+" cause: cause: "+ex.getCause());
		}
		return null;
		
	}
	public List<Products> getProductsByCat(int catId){
		return productRepository.findByCatId(catId);
	}
	
}
