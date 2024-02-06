package com.c.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.MainCategory;
import com.c.ecart.repository.MainCategoryRepository;

@Service
public class MainCategoryService {

	@Autowired
	private MainCategoryRepository mainCategoryRepository;
	
	public MainCategory addMainCategory(MainCategory mainCat) {
		try {
			return mainCategoryRepository.save(mainCat);
		}
		catch(Exception ex){
			System.err.println("Exception occures in addMainCategory: "+ex.getMessage()+"cause: "+ex.getCause());
			
		}
		return null;
	}
	public boolean removeMainCategory(int mainCatId) {
		try {
			mainCategoryRepository.deleteById(mainCatId);
			return true;
		}
		catch (Exception ex) {
			System.err.println("Exception occured in removeMainCategory: "+ex.getMessage()+"cause: "+ex.getCause());
			
		}
		return false;
	}
	public List<MainCategory>getMainCategories(){
		try {
			mainCategoryRepository.findAll();
		}
		catch (Exception ex) {
			System.err.println("Exception occured in getAllMainCategories: "+ex.getMessage()+"cause "+ex.getCause());
			
		}
		return null;
	}
}
