package com.ludmylla.invoice.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ludmylla.invoice.exceptions.UserNotFoundException;
import com.ludmylla.invoice.mapper.UserMapper;
import com.ludmylla.invoice.model.User;
import com.ludmylla.invoice.model.dto.UserCreateAndListAllDTO;
import com.ludmylla.invoice.model.dto.UserListAndUpdateDTO;
import com.ludmylla.invoice.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
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
	public ResponseEntity<List<UserListAndUpdateDTO>> getAllUsers(){
		try {
			List<User> list = userService.getAllUsers();
			List<UserListAndUpdateDTO> userListUpdateDTO = UserMapper.INSTANCE.dtoUserListUpdateDTO(list);
			return ResponseEntity.ok(userListUpdateDTO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserListAndUpdateDTO> findById(@PathVariable("id") Long id){
		try {
			User user = userService.findById(id);
			UserListAndUpdateDTO userListUpdateDTO = UserMapper.INSTANCE.dtoUserListUpdateDTO(user);
			return ResponseEntity.ok(userListUpdateDTO);
		}catch (UserNotFoundException e) {
			throw new UserNotFoundException("User does not exist");
		} catch (Exception e) {
			return new ResponseEntity<UserListAndUpdateDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/findCpf/{cpf}")
	public ResponseEntity<UserListAndUpdateDTO> findByCpf(@PathVariable("cpf") String cpf){
		try {
			User user = userService.findByCpf(cpf);
			UserListAndUpdateDTO userListUpdateDTO = UserMapper.INSTANCE.dtoUserListUpdateDTO(user);
			return ResponseEntity.ok(userListUpdateDTO);
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException("User does not exist");
		}catch (Exception e) {
			return new ResponseEntity<UserListAndUpdateDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping
	public ResponseEntity<String> updateUser(@Valid @RequestBody UserListAndUpdateDTO userListAndUpdateDTO){
		try {
			User user = UserMapper.INSTANCE.toUser(userListAndUpdateDTO);
			userService.updateUser(user);
			return ResponseEntity.ok().build();
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException("User does not exist");
		}catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
		try {
			userService.deleteUser(id);
			return ResponseEntity.noContent().build();
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException("User does not exist");
		}catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
