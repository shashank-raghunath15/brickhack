package com.brickhack.brokemenu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brickhack.brokemenu.dto.Login;
import com.brickhack.brokemenu.model.User;

@RestController
public class UserController extends Controller{
	
	@PostMapping("/signUp")
	public User signup(@RequestBody User user){
		return getUserService().signUp(user);
	}

	public boolean usernameExists(@RequestParam String username){
		return getUserService().exists(username);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody Login login){
		return getUserService().login(login);
	}
}
