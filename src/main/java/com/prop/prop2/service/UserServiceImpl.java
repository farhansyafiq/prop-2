package com.prop.prop2.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.prop.prop2.model.UserModel;
import com.prop.prop2.repository.UserDb;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDb userDb;
	
	
	@Override
	public UserModel addUser(UserModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDb.save(user);
	}

	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
	@Override
	public UserModel findByUsername(String username) {
		return userDb.findByUsername(username);
	}
}
 