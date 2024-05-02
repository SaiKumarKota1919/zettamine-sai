package com.zettamine.login.service;

import org.passay.EnglishCharacterData;



import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zettamine.login.dto.EmailDto;
import com.zettamine.login.dto.UserDto;
import com.zettamine.login.entity.Users;
import com.zettamine.login.exception.AccountLockException;
import com.zettamine.login.exception.InvalidCredentialsException;
import com.zettamine.login.exception.ResourceNotFoundException;
import com.zettamine.login.mapper.UserMapper;
import com.zettamine.login.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private EmailServices emailServices;

	public void createUser(UserDto userDto) {
		
		Users user = UserMapper.mapToUser(userDto);
		user.setTempPwd(generatePassayPassword());
		user.setLoginStatus(0);
		user.setAttempts(0);

		

      userRepo.save(user);
      
      EmailDto emailDto = new EmailDto();
      emailDto.setEmail(user.getEmail());
      emailDto.setFName(user.getFirstName());
      emailDto.setLName(user.getLastName());
      emailDto.setPassword(user.getTempPwd());
      emailDto.setSubject("Account Created Successfully");
      
      
      emailServices.sendEmail(emailDto);
      
		
	}
	public static String generatePassayPassword() {

		PasswordGenerator gen = new PasswordGenerator();
		CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
		CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
		lowerCaseRule.setNumberOfCharacters(2);

		CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
		CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
		upperCaseRule.setNumberOfCharacters(2);

		CharacterData digitChars = EnglishCharacterData.Digit;
		CharacterRule digitRule = new CharacterRule(digitChars);
		digitRule.setNumberOfCharacters(2);

		CharacterData specialChars = new CharacterData() {
			public String getErrorCode() {
				return "cannot generate special characters";
			}

			public String getCharacters() {
				return "!@#$%^&*()_+";
			}
		};
		CharacterRule splCharRule = new CharacterRule(specialChars);
		splCharRule.setNumberOfCharacters(2);

		String password = gen.generatePassword(10, splCharRule, lowerCaseRule, upperCaseRule, digitRule);

		return password;
	}
	public void changeTempPswd(String userName, String tempPassword) {

			 Users user = userRepo.findByEmail(userName).orElseThrow(()->new ResourceNotFoundException("User", "Email", userName));
			
			 if(!user.getTempPwd().equals(tempPassword))
			 {
				 throw new InvalidCredentialsException();
				 
			 }
		
	}
	public Users getUserByEmail(String email) {
			
		System.out.println(email);
			Users user = userRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("User", "Email", email));
		
			return user;
	}
	public UserDto login(String userName, String password) {

		Users user= getUserByEmail(userName);
		UserDto userDto = UserMapper.mapToUserDto(user);
		if(user.getAccountLock())
		{
			throw new AccountLockException();
			
		}
		
		if(user.getLoginStatus()==0 && user.getTempPwd().equals(password) )
		{
			
				user.setLoginStatus(1);
				userDto.setLoginStatus(1);
				user.setAttempts(0);
				userDto.setAttempts(0);
				
				userRepo.save(user);
		
		}
		
		else if(user.getLoginStatus()==1 && user.getPassword().equals(password))
		{
			
			user.setAttempts(0);
			userDto.setAttempts(0);
			
			userRepo.save(user);
		}
		else {
			user.setAttempts(user.getAttempts()+1);
			userDto.setAttempts(user.getAttempts());
			if(user.getAttempts()==5)
			{
				user.setAccountLock(true);
			}
			
			userRepo.save(user);
			
			throw new InvalidCredentialsException(UserMapper.mapToUserDto(user));
		}
		return userDto;
		
		
	}

}
