package com.zettamine.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zettamine.login.dto.UserDto;
import com.zettamine.login.entity.Users;
import com.zettamine.login.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody @Valid UserDto userDto)
	{
		
		userService.createUser(userDto);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	@GetMapping("/fetch")
	public ResponseEntity<?> getUserByEmail(@RequestParam String email)
	{
		userService.getUserByEmail(email);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String userName,@RequestParam String password)
	
	{
		
	UserDto userDto=	userService.login(userName,password);
		
		return new ResponseEntity<>(userDto,HttpStatus.OK);
		
	}
	
	
	

}
