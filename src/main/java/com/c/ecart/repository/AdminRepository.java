package com.c.ecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.c.ecart.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

@Query(nativeQuery = true,value = "select count(*) from admin where username=:username and password=:password and status=:status")
public Integer getAdminByUnameAndPass(@Param("username")String username,@Param("password") String password,@Param("status")String status);
}
