package com.c.ecart.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.c.ecart.GenericResponse;
import com.c.ecart.model.Category;
import com.c.ecart.service.CategoryService;

import ch.qos.logback.core.joran.conditional.IfAction;

@RestController
@RequestMapping("category")
@CrossOrigin("http://localhost:4200")
public class CategoryController {
		@Autowired
		private CategoryService categoryService;
		
		@PostMapping("add")
		public GenericResponse<Category> addCategory(@RequestParam Integer catId,@RequestParam String catName,
				@RequestParam String catDesc,@RequestParam String Status,
				@RequestParam Integer mainCatId,@RequestParam MultipartFile catImage) throws IOException{
		Category category = new Category();
		if(catId!=null && catId!=0) {
			category.setCatId(catId);
		}
		if(catImage!=null){
			category.setCatImage(Base64.getEncoder().encodeToString(catImage.getBytes()));
			category.setImageName(catImage.getOriginalFilename());
		}
		category.setCatName(catName);
		category.setCatDesc(catDesc);
		category.setStatus(Status);
		category.setMainCatId(mainCatId);
		Category response = categoryService.addCategory(category);
		if(response!=null) {
			return GenericResponse.<Category>builder().success(true).data(response).message("").build();
		}
		else {
			return GenericResponse.<Category>builder().success(true).data(response).message("").build();
		}
		
}
		
		@GetMapping("remove/{catId}")
		public GenericResponse<Boolean> removeCategory(@PathVariable("catId")int catId) {
			if(categoryService.removeCategory(catId)) {
				return GenericResponse.<Boolean>builder().success(true).data(true).message("Category deleted Successfully").build();
			}
			else {
				return GenericResponse.<Boolean>builder().success(false).data(false).message("Category not deleted,Try again").build();
			}
		}
		
		@GetMapping("/all")
		public GenericResponse<List<Category>> getCategories(){
		List<Category>response = categoryService.getCategories();
		if(response!=null) {
		return GenericResponse.<List<Category>>builder().success(true).data(response).message("").build();
		}
		else {
			return GenericResponse.<List<Category>>builder().success(false).data(null).message("No record found").build();
		}
		}
		
		@GetMapping("by-id/{catId}")
		public GenericResponse<Category> getCategory(@PathVariable("catId") int catId){
			Category response = categoryService.getCategory(catId);
			if(response!= null) {
				return GenericResponse.<Category>builder().success(true).data(response).build();
			}
			else {
				return GenericResponse.<Category>builder().success(false).data(null).build();		
			}
}

		@GetMapping("by-ref-id/{mainCatId}")
		public GenericResponse<List<Category>> getCategoryByMainCatId(@PathVariable("mainCatId") int mainCatId) { 
		    List<Category> response = categoryService.getCategoriesByMainCatId(mainCatId);

		    if (response != null) {
		        // If successful, return a GenericResponse with success=true, dataList=response, and an empty message
		        return GenericResponse.<List<Category>>builder().success(true).data(response).message("").build();
		    } else {
		        // If unsuccessful, return a GenericResponse with success=false, dataList=null, and an empty message
		        return GenericResponse.<List<Category>>builder().success(false).dataList(null).message("No record found").build();
		    }
		}																																																																													

}
