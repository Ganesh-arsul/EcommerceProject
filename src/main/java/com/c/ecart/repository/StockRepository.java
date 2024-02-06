package com.c.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.c.ecart.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer>{

	

}
