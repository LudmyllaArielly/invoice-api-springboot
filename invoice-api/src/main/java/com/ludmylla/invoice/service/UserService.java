package com.ludmylla.invoice.service;

import java.util.List;

import com.ludmylla.invoice.model.User;

public interface UserService {
	
	Long createUser(User user);
	
	List<User> getAllUsers();
	
	User findById(Long id);
	
	User findByCpf(String cpf);
	
	void updateUser(User user);
	
	void deleteUser(Long id);

}
