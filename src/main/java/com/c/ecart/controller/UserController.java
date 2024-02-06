package com.c.ecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.c.ecart.model.User;
import com.c.ecart.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add-user")
	public User addUser(@RequestBody User user) {
		User u = userService.addUser(user);
		if(u!=null) {
			return u;
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/user-login")
	public String login(@RequestBody User user) {
		if(userService.login(user.getEmail(), user.getPassword())) {
			return "success";
		}
		else {
			return "unsuccess";
		}
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable("userId") int userId) {
		return userService.getUser(userId);
	}
}
