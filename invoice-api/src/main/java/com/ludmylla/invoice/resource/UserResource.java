package com.ludmylla.invoice.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = {"https://invoice-api.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@ApiOperation(value = "Create a user")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created user successfully"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
	public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateAndListAllDTO userCreateAndListAllDTO){
		try {
			User user = UserMapper.INSTANCE.toUser(userCreateAndListAllDTO);
			userService.createUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).body("Created successfully. ");
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@ApiOperation(value = "Search all users")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Search successfully"),
			@ApiResponse(code = 400, message = "An exception was raised")
	})
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
	
	@ApiOperation(value = "Find the user by id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "find the user successfully"),
			@ApiResponse(code = 404, message = "User not found")
	})
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
	
	@ApiOperation(value = "Find the user by cpf")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "find the user successfully"),
			@ApiResponse(code = 404, message = "User not found")
	})
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
	
	@ApiOperation(value = "Updated the user")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Updated user successfully"),
			@ApiResponse(code = 404, message = "An exception was raised")
	})
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
		
}
