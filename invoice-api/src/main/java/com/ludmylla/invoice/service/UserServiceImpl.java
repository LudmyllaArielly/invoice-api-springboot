package com.ludmylla.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ludmylla.invoice.exceptions.UserNotFoundException;
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

	@Override
	public List<User> getAllUsers() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("{message.userNotFound}"));		
	}
	
	@Override
	public User findByCpf(String cpf) {
		validIfUserCpfExists(cpf);
		return userRepository.findByCpf(cpf);
	}
	
	private void validIfUserCpfExists(String cpf) {
		Boolean userCpfExists = cpf == null;
		if(userCpfExists) {
			throw new UserNotFoundException("{message.userNotFound}");
		}
	}

}
