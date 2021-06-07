package com.ludmylla.invoice.service;

import java.util.List;

import com.ludmylla.invoice.model.User;

public interface UserService {
	
	Long createUser(User user);
	
	List<User> getAllUsers();

}
