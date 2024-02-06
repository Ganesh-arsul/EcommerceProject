package com.c.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.c.ecart.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(nativeQuery = true, value = "select count(*)from user where email=:username and password=:password and status='active'")
	public Integer login(@Param("username")String username,@Param("password")String password);
}
