package com.c.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.SubCategory;
import com.c.ecart.repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	
	@Autowired 
	private SubCategoryRepository subCategoryRepository;
	
	public SubCategory addSubCategory(SubCategory subCategory) {
		try {
			return subCategoryRepository.save(subCategory);
		}
		catch (Exception ex) {
			System.err.println("Exception occured in addSubCatgeory: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}
	public boolean removeSubCategory(int subCatId) {
		try {
			subCategoryRepository.deleteById(subCatId);
			return true;
		}
		catch (Exception ex) {
			System.err.println("Exception occured in removeSubCatgeory: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return false;
	}
	
	public List<SubCategory> getAllSubCategories(){
		try {
			return subCategoryRepository.findAll();
		}
		catch (Exception ex) {
			System.err.println("Exception occured in getAllSubCategories: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}
	
	public List<SubCategory> getAllSubCategoriesByCatId(int catId){
		try {
			return subCategoryRepository.findByCatId(catId);
		}
		catch (Exception ex) {
			System.err.println("Exception occured in getAllSubCategories: "+ex.getMessage()+"cause: "+ex.getCause());
		}
		return null;
	}


}
