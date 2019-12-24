package com.spiders.app.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spiders.app.constants.AppConstants;
import com.spiders.app.dto.LoginDto;
import com.spiders.app.dto.UserDto;
import com.spiders.app.service.UserService;

@Controller
@SessionAttributes(value = "userDetails")
public class LoginAndLogoutController {
	
	@Autowired
	UserService userService;
	
	// for geting the data from login from 
	@RequestMapping( value = "/login" , method = RequestMethod.POST )
	String login(LoginDto details , Model model){
		
		UserDto userFromDb =
				userService.findUserByUserNameOrEmailOrMobileNo(details.getUserName());
		System.out.println(userFromDb);
		
		if(userFromDb == null) {
			model.addAttribute("msg", "user information is wrong");
			return "loginpage";
		}
		if( ! userFromDb.getPassword().equals(details.getPassword())) {
			model.addAttribute("msg", "password is wrong");
			return "loginpage";
		}
		
		model.addAttribute("userName" ,userFromDb.getFirstName() + " " +  userFromDb.getLastName());
		
		// logic to rediret to admin or user page will come here
		if(userFromDb.getRole().equals(AppConstants.ROLE_ADMIN)) {
			model.addAttribute("userDetails", userFromDb);
			return "admindashboard";
		}
		else if(userFromDb.getRole().equals(AppConstants.ROLE_USER)) {
			model.addAttribute("userDetails", userFromDb);
			return "userdashboard";
		}	
	
		return null;
	}
	
	
	// for dispaying login form 
		@RequestMapping("/loginpage")
		String displayLoginPage() {
			System.out.println("diaply login page");
			return "loginpage";
		}
	
}
