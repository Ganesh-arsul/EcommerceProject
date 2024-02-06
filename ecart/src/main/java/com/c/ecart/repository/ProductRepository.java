package com.c.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.c.ecart.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer>{
	
	@Query(nativeQuery = true, value = "select * from products where catId:catId ")
    public List<Products> findByCatId(@Param("catId") Integer catId);
}
