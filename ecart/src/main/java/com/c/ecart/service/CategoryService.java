package com.c.ecart.service;

import java.awt.event.FocusEvent.Cause;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.Category;
import com.c.ecart.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	/*
	 * It will work insert and update 
	 */
	public Category addCategory(Category category) {
		try {
		return categoryRepository.save(category);
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in addCategory : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return null;
	}
	public boolean removeCategory(int categoryId) {
		try {
		categoryRepository.deleteById(categoryId);
		return true;
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in addCategory : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return false;
	}
	public List<Category> getCategories(Category category) {
		try {
		return categoryRepository.findAll();
		
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in getCategories : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return null;
	}
	public Category getCategory(int catgoryId) {
		try {
		return categoryRepository.findById(catgoryId).get();
		
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in getCategory : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return null;
	}

}

