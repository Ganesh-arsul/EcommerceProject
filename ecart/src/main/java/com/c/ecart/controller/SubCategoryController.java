package com.c.ecart.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.c.ecart.GenericResponse;
import com.c.ecart.model.Category;
import com.c.ecart.model.SubCategory;
import com.c.ecart.service.SubCategoryService;


@RestController
@RequestMapping("sub-category")
@CrossOrigin("http://localhost:4200")
public class SubCategoryController {
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@PostMapping("add")
	public GenericResponse<SubCategory> addSubCategory(@RequestParam Integer subCatId,@RequestParam String catName,
			  	@RequestParam String catDesc,@RequestParam MultipartFile catImage,
			  	@RequestParam String status,@RequestParam Integer catId) throws IOException{
		SubCategory subCategory = new SubCategory();
		if(subCatId !=0) {
			subCategory.setSubCatId(subCatId);
		}
		subCategory.setCatName(catName);
		subCategory.setCatDesc(catDesc);
		if(catImage !=null) {
			subCategory.setCatImage(Base64.getEncoder().encodeToString(catImage.getBytes()));
			subCategory.setImageName(catImage.getOriginalFilename());
		}
		subCategory.setStatus(status);
		subCategory.setCatId(catId);
		SubCategory response =  subCategoryService.addSubCategory(subCategory);
		if(response != null) {
			return GenericResponse.<SubCategory>builder().success(true).data(response).message("SubCategory added Successfully").build();
		}
		else {
			return GenericResponse.<SubCategory>builder().success(false).data(null).message("SubCategory added Successfully").build();
		}
	}
	
	@GetMapping("remove/{subCatId}")
	public GenericResponse<Boolean> removeSubCategory(@PathVariable("subCatId")int subCatId) {
		if(subCategoryService.removeSubCategory(subCatId)) {
			return GenericResponse.<Boolean>builder().success(true).data(true).message("Sub Category deleted Successfully").build();
		}
		else {
			return GenericResponse.<Boolean>builder().success(false).data(false).message("Sub Category not deleted,Try again").build();
		}
	}
	
	@GetMapping("/all")
	public GenericResponse<List<SubCategory>> getSubCategories(){
	List<SubCategory>response = subCategoryService.getAllSubCategories();
	if(response!=null) {
	return GenericResponse.<List<SubCategory>>builder().success(true).data(response).message("").build();
	}
	else {
		return GenericResponse.<List<SubCategory>>builder().success(false).data(null).message("No record found").build();
	}
	}
	
	@GetMapping("by-ref-id/{catId}")
	public GenericResponse<List<SubCategory>>getSubCategoryByMainCatId(@PathVariable("catId") int catId) { 
	    List<SubCategory> response = subCategoryService.getAllSubCategoriesByCatId(catId);

	    if (response != null && !response.isEmpty()) {
	        // If successful, return a GenericResponse with success=true, dataList=response, and an empty message
	        return GenericResponse.<List<SubCategory>>builder().success(true).data(response).message("").build();
	    } else {
	        // If unsuccessful, return a GenericResponse with success=false, dataList=null, and an empty message
	        return GenericResponse.<List<SubCategory>>builder().success(false).dataList(null).message("No record found").build();
	    }
	}																																																																													

}
	
