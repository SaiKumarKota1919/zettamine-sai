package com.zettamine.login.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDto {
	
	private Integer userId;
	@NotBlank
	private String firstName;
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9!-.]+@(?:gmail|yahoo|zettamine)\\.(?:com|net|in)$")
	private String email;
	@NotBlank
	private String lastName;
	@NotNull
	private Integer roleId;
	private Integer loginStatus;
	private Boolean accountLock;
	private Integer attempts;

}
