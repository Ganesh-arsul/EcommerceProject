package com.c.ecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.c.ecart.model.SubCategory;
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
	
	@Query(nativeQuery = true,value = "select * from sub_category where cat_id= :catId and status='active'")
	List<SubCategory> findByCatId(@Param("catId") Integer catId);

}
