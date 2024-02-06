package com.c.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c.ecart.GenericResponse;
import com.c.ecart.model.MainCategory;
import com.c.ecart.service.MainCategoryService;

import lombok.Builder;

@RestController
@RequestMapping("main-category")
@CrossOrigin("http://localhost:4200")
@Builder
public class MainCategoryController {

	@Autowired
	private MainCategoryService mainCategoryService;
	
	
	@PostMapping("add")
	public GenericResponse<MainCategory> addMainCategory(@RequestBody MainCategory mainCategory){
		MainCategory mainCat= mainCategoryService.addMainCategory(mainCategory);
		if(mainCat!=null) {
		return GenericResponse.<MainCategory>builder()
				.success(true)
				.data(mainCat)
				.message("Main Category added successfully")
				.build();
		}
		else {
			return GenericResponse.<MainCategory>builder()
					.success(false)
					.data(mainCat)
					.message("Main Category not added...! Try Again")
			   		.build();
		}
	}
}
