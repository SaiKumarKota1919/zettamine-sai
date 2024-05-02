package com.zettamine.login.exception;

import com.zettamine.login.dto.UserDto;

public class InvalidCredentialsException extends RuntimeException{

	private UserDto userDto;
	
	
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public InvalidCredentialsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvalidCredentialsException(UserDto userdto) {
		
		this.userDto= userdto;
		
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
