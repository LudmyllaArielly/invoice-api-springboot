package com.ludmylla.invoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludmylla.invoice.model.User;
import com.ludmylla.invoice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Long createUser(User user) {
		User userSave =	userRepository.save(user);
		return userSave.getId();
	}
	

}
