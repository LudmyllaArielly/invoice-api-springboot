package com.ludmylla.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ludmylla.invoice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByCpf (String cpf);
	
}
