package com.zettamine.login.mapper;

import com.zettamine.login.dto.UserDto;
import com.zettamine.login.entity.Users;

public class UserMapper {
	
	public static Users mapToUser(UserDto userDto)
	{
		Users user = new Users();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setRoleId(userDto.getRoleId());

		
		return user;
		
		
	}
	public static UserDto mapToUserDto(Users user)
	{
		UserDto userDto= new UserDto();
		
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setAccountLock(user.getAccountLock());
		userDto.setAttempts(user.getAttempts());
		userDto.setRoleId(user.getRoleId());
		userDto.setLoginStatus(user.getLoginStatus());
		userDto.setUserId(user.getUserId());
		
		return userDto;
	}

}
