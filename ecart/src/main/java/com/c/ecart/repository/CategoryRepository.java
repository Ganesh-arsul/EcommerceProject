package com.c.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.c.ecart.model.Category;
import com.c.ecart.model.Products;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
	@Query(nativeQuery = true, value = "select * from category where main_cat_id=:mainCatId")
    public List<Category> findByCatId(@Param("mainCatId") Integer mainCatId);
}

