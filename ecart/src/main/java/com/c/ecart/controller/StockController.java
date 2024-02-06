package com.c.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c.ecart.model.Stock;
import com.c.ecart.service.StockService;

@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@PostMapping("/add-stock")
	public Stock addStock(@RequestBody Stock stock) {
		Stock s= stockService.addStock(stock);
		if(s!=null){
			return s;
			
		}
		else {
			return null;
		}
		
	}
	
	@GetMapping("/delete-stock/{stockId}")
	public String deleteStock(@PathVariable("stockId") int stockId) {
		if(stockService.deleteStock(stockId)) {
			return "success";
		}
		else {
			return "unsuccess";
		}
	}
	@GetMapping("/stocks")
	public List<Stock> getStocks(){
		return stockService.getStocks();
	}
	@GetMapping("/stocks/{stockId}")
	public Stock getStock(@PathVariable("stockId") int stockId){
		return stockService.getStock(stockId);
	}
	

}
