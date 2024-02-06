package com.c.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.Admin;
import com.c.ecart.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public int loginAdmin(Admin admin) {
		try {
		return adminRepository.getAdminByUnameAndPass(admin.getUsername(),admin.getPassword(),admin.getStatus());
	}
		catch (Exception ex) {
			System.err.println("Error occured in loginAdmin:"+ex.getMessage()+"cause:"+ex.getCause());
			
		}
			return 0;
		}
}
