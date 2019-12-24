package com.spiders.app.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spiders.app.dto.UserDto;
import com.spiders.app.repository.UserDao;

@Repository
public class UserService {
	// All busniess logic will be written in Service layer only
	
	@Autowired
	private UserDao userDao;
	
	public 
		UserDto 
			findUserByUserNameOrEmailOrMobileNo
				(String loginInfo){
		
	return 
			userDao.
				findUserByUserNameOrEmailOrMobileNo
					(loginInfo);
	}
	
	
	
	
	
	
	
	
}
