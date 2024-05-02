package com.zettamine.login.repo;

import java.io.Serializable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zettamine.login.entity.Users;
import java.util.List;
import java.util.Optional;




@Repository
public interface UserRepo extends JpaRepository<Users, Serializable>{
	
	public Optional<Users>  findByEmail(String email); 

}
