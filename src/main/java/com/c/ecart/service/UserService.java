package com.c.ecart.service;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.ecart.model.User;
import com.c.ecart.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		try {
			return userRepository.save(user);
		}
		catch(Exception ex) {
			System.err.println("Exception Occured in addUser: "+ex.getMessage()+"Cause: "+ex.getCause());
			
		}
		return null;
	}
	public boolean login(String username,String password) {
		if(userRepository.login(username,password)>0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public List<User> getUsers() {
		try {
			return userRepository.findAll();
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getUsers:"+ex.getMessage()+" Cause: "+ex.getCause());
		}
		return null;	
	}
	public User getUser(int userId) {
		try {
			return userRepository.findById(userId).get();
		}
		catch (Exception ex) {
			System.err.println("Exception Occured in getUser:"+ex.getMessage()+" Cause: "+ex.getCause());
		}
		return null;
	}

}
