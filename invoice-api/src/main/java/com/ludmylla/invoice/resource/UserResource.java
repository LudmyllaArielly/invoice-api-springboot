package com.ludmylla.invoice.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.invoice.model.User;
import com.ludmylla.invoice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody User user){
		try {
			userService.createUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully. ");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
