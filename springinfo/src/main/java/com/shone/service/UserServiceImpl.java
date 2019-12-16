package com.shone.service;



import org.springframework.beans.factory.annotation.Autowired;

import com.shone.dao.UserDao;
import com.shone.model.Login;
import com.shone.model.Register;

public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public void Register(com.shone.model.Register user) {
		userDao.register(user);
		System.out.println("user service implementation");
		
	}

	public com.shone.model.Register validateUser(Login login) {
		// TODO Auto-generated method stub
		return userDao.validateUser(login);
	}

	




}
