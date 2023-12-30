package com.zm.ams.services.impl;

import java.sql.SQLException;

import com.zm.ams.dao.AmsDao;
import com.zm.ams.dao.impl.UserDao;
import com.zm.ams.dto.Amc;
import com.zm.ams.dto.User;
import com.zm.ams.marker.SearchCriteria;
import com.zm.ams.services.UserService;

public class UserServiceImpl implements UserService {

	AmsDao<User, SearchCriteria> userDao;
	
	public UserServiceImpl()
	{
		userDao= new UserDao();
	}
	

	@Override
	public int getId(User attribute) throws SQLException {
		
		return userDao.getId(attribute);
	}

	@Override
	public void save(User user) throws SQLException {
		
		
		
	}
	

}
