package com.shone.dao;

import com.shone.model.Login;
import com.shone.model.Register;

public interface UserDao {

	void register(Register user);

	Register validateUser(Login login);
	

}
