package com.brickhack.brokemenu.service.impl;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.brickhack.brokemenu.dto.Login;
import com.brickhack.brokemenu.model.User;
import com.brickhack.brokemenu.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl implements UserService{

	@Override
	public User signUp(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
		return getUserRepository().save(user);
	}

	@Override
	public User login(Login login) {
		User user = getUserRepository().findByUsername(login.getUsername());
		if(user == null){
			return null;
		}else if(BCrypt.checkpw(login.getPassword(), user.getPassword())){
			return user;
		}
		return null;
	}

	@Override
	public boolean exists(String username) {
		return getUserRepository().findByUsername(username) != null ? true: false; 
	}

}
