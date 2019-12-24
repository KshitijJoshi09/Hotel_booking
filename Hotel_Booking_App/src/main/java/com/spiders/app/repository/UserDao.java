package com.spiders.app.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spiders.app.dto.UserDto;

@Repository
public class UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDto findUserByUserNameOrEmailOrMobileNo(String loginInfo){
		UserDto user = null;
		try (Session session = sessionFactory.openSession()){
		Query<UserDto> query = session.createQuery("From UserDto where userName=:loginInfo "
				+ " or mobileNo=:loginInfo ");
		query.setParameter("loginInfo", loginInfo);
		user = query.uniqueResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
			return user;
	}

	
	
	
	
	
}
