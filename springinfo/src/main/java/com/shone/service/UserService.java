package com.shone.service;

import com.shone.model.Login;
import com.shone.model.Register;

public interface UserService {

	void Register(Register user);

	com.shone.model.Register validateUser(Login login);


}
