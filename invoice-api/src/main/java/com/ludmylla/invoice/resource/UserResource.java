package com.ludmylla.invoice.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.invoice.mapper.UserMapper;
import com.ludmylla.invoice.model.User;
import com.ludmylla.invoice.model.dto.UserCreateAndListAllDTO;
import com.ludmylla.invoice.model.dto.UserListDTO;
import com.ludmylla.invoice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateAndListAllDTO userCreateAndListAllDTO){
		try {
			User user = UserMapper.INSTANCE.toUser(userCreateAndListAllDTO);
			userService.createUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully. ");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<UserListDTO>> getAllUsers(){
		try {
			List<User> list = userService.getAllUsers();
			List<UserListDTO> userListDTO = UserMapper.INSTANCE.dtoUserListDTO(list);
			return ResponseEntity.ok(userListDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserListDTO> findById(@PathVariable("id") Long id){
		try {
			User user = userService.findById(id);
			UserListDTO userListDTO = UserMapper.INSTANCE.dtoUserListDTO(user);
			return ResponseEntity.ok(userListDTO);
		} catch (Exception e) {
			return new ResponseEntity<UserListDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<UserListDTO> findByCpf(@PathVariable("cpf") String cpf){
		try {
			User user = userService.findByCpf(cpf);
			UserListDTO userListDTO = UserMapper.INSTANCE.dtoUserListDTO(user);
			return ResponseEntity.ok(userListDTO);
		} catch (Exception e) {
			return new ResponseEntity<UserListDTO>(HttpStatus.NOT_FOUND);
		}
	}
	

}
