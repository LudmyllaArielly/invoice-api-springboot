package com.ludmylla.invoice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
				.orElseThrow(() -> new UserNotFoundException("User does not exist"));		
	}
	
	@Override
	public User findByCpf(String cpf) {
		User userCpf = userRepository.findByCpf(cpf);
		validIfUserCpfExists(userCpf);
		return userCpf;
	}
	
	@Modifying
	@Override
	public void updateUser(User user) {
		validIfUserExists(user.getId());
		userRepository.save(user);
	}
	
	private void validIfUserCpfExists(User userCpf) {
		if(userCpf == null)
			throw new UserNotFoundException("User does not exist");
	}
	
	private void validIfUserExists(Long id) {
		findById(id);
	}

}
