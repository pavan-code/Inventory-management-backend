package com.IMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.IMS.dto.UserDTO;
import com.IMS.entity.Request;
import com.IMS.entity.User;
import com.IMS.entity.UserResponse;
import com.IMS.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome to Inventory Management System";
	}
	
	@PostMapping("/register")
	public UserResponse<User> register(@RequestBody UserDTO userDto) {
		User user = new User(userDto);
		User saved = userService.register(user);
		return new UserResponse<>(true, 200, "Registration successful!", saved, null);
	}
	
	@PostMapping("/login")
	public UserResponse<User> login(@RequestBody Request request) {
		return userService.login(request);
		
	}
}

