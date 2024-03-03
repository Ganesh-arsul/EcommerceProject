package com.c.ecart.service;

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
	public List<Category> getCategories() {
		try {
		return categoryRepository.findAll();
		
		
	}
		catch (Exception ex) {
			System.err.println("Exception Occured in getCategories : "+ex.getMessage()+" Cause cause "+ex.getCause());  
		}
		return null;
	}
	
	public Category getCategory(int catId) {
	    try {
	        return categoryRepository.findById(catId).orElse(null);
	    } catch (Exception ex) {
	        System.err.println("Exception Occurred in getCategory: " + ex.getMessage() + " Cause: " + ex.getCause());
	        return null;
	    }
	}

	
	    public List<Category> getCategoriesByMainCatId(int mainCatId) {
	        System.out.println("Getting categories for main cat ID: " + mainCatId);

	        // Your logic to query the database or retrieve categories
	        List<Category> categories = categoryRepository.findByCatId(mainCatId);

	        System.out.println("Categories retrieved: " + categories);

	        return categories;
	    }
}

