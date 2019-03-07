package com.prop.prop2.service;

import com.prop.prop2.model.UserModel;

public interface UserService {
	UserModel addUser(UserModel user);
	UserModel findByUsername(String username);
	public String encrypt(String password);
}
