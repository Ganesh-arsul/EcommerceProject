package com.c.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c.ecart.model.Category;
import com.c.ecart.service.CategoryService;

@RestController
public class CategoryController {
		@Autowired
		private CategoryService categoryService;
		
		@PostMapping("add-category")
		public Category addCategory(@RequestBody Category category) {
			return categoryService.addCategory(category);
			
		}
		
		@GetMapping("remove-category/{catId}")
		public String removeCategory(@PathVariable("catId")int catId) {
			if(categoryService.removeCategory(catId)) {
				return "success";
			}
			else {
				return "unsuccess";
			}
		}
		
		@GetMapping("/categories")
		public List<Category> getCategories(){
		return	categoryService.getCategories(null);
		 
		}
		@GetMapping("categories/{catId}")
		public Category getCategory(@PathVariable("catId")int catId) {
			return categoryService.getCategory(catId);
		}

}
