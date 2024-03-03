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

import com.c.ecart.model.Products;
import com.c.ecart.service.ProductService;

@RestController
@RequestMapping("product")
@CrossOrigin("http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductService  productService;
	
	@PostMapping("add")
	public GenericResponse<Products> addProduct(@RequestParam Integer prodId,@RequestParam String prodName,
			@RequestParam String prodDesc,@RequestParam Double prodPrice,
			@RequestParam String status,@RequestParam Integer catId,@RequestParam MultipartFile prodImage) throws IOException{
	Products product = new Products();
	if(prodId!=0) {
		product.setProdId(prodId);
	}
	if(prodImage!=null) {
		product.setProdImg(Base64.getEncoder().encodeToString(prodImage.getBytes()));
		product.setImageName(prodImage.getOriginalFilename());
	}
	product.setProdName(prodName);
	product.setProdDesc(prodDesc);
	product.setProdPrice(prodPrice);
	product.setStatus(status);
	product.setCatId(catId);
	Products response = productService.addProduct(product);
	if(response!=null) {
		return GenericResponse.<Products>builder().success(true).data(response).message("").build();
	}
	else {
		return GenericResponse.<Products>builder().success(false).data(response).message("").build();
	}
	}
	
	@GetMapping("/remove/{productId}")
	public GenericResponse<Boolean> removeProduct(@PathVariable("productId")int productId) {
		if(productService.removeProduct(productId)) {
			return GenericResponse.<Boolean>builder().success(true).data(true).message("").build();
		}
		else {
			return GenericResponse.<Boolean>builder().success(false).data(false).message("").build();
		}
	}
	
	@GetMapping("/all")
	public GenericResponse<List<Products>> getProducts(){
		List<Products>products = productService.getProducts();
		if(products!=null) {
		return GenericResponse.<List<Products>>builder().success(true).data(products).message("").build();
		}
		else {
			return GenericResponse.<List<Products>>builder().success(false).data(null).message("").build();
		}
		}
	
	@GetMapping("By-id/{productId}")
	public GenericResponse<Products> getProduct(@PathVariable("productId")int productId){ 
		Products product = productService.getProduct(productId);
		if(product!=null) {
			return GenericResponse.<Products>builder().success(true).data(product).message("").build();
		}
		else {
			return GenericResponse.<Products>builder().success(false).data(null).message("").build();
		}
		}
	
	@GetMapping("By-ref-id/{catId}")
	public GenericResponse<Products> getProductByCat(@PathVariable("catId")int catId){ 
		Products product = productService.getProduct(catId);
		if(product!=null) {
			return GenericResponse.<Products>builder().success(true).data(product).message("").build();
		}
		else {
			return GenericResponse.<Products>builder().success(false).data(null).message("").build();
		}
		}
	
}
