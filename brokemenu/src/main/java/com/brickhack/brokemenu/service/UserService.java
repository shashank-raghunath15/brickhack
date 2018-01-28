package com.brickhack.brokemenu.service;

import com.brickhack.brokemenu.dto.Login;
import com.brickhack.brokemenu.model.User;

public interface UserService {

	public User signUp(User user);

	public User login(Login login);

	public boolean exists(String username);
}
