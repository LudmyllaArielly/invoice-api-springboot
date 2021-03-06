package com.ludmylla.invoice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.ludmylla.invoice.model.User;
import com.ludmylla.invoice.model.dto.UserCpfDTO;
import com.ludmylla.invoice.model.dto.UserCreateAndListAllDTO;
import com.ludmylla.invoice.model.dto.UserListAndUpdateDTO;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({
		@Mapping(target = "id", ignore = true), 
		@Mapping(target = "firstName", ignore = true),
		@Mapping(target = "lastName", ignore = true),
		@Mapping(target = "dateOfBirth", ignore = true), })
	User toUser(UserCpfDTO source);
	
	@Mapping(target = "id", ignore = true)
	User toUser (UserCreateAndListAllDTO source);
	
	UserCreateAndListAllDTO dtoUserCreateListAllDTOc(User source);

	List<UserCreateAndListAllDTO> dtoUserCreateAndListAllDTO(List<User> source);
	
	User toUser (UserListAndUpdateDTO source);
	
	UserListAndUpdateDTO dtoUserListUpdateDTO (User source);
	
	List<UserListAndUpdateDTO> dtoUserListUpdateDTO(List<User> source);
	

}
