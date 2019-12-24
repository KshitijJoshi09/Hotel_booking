package com.spiders.app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spiders.app.constants.AppConstants;
import com.spiders.app.dto.UserDto;

@Controller
public class AppController {
	
	Logger log = Logger.getLogger(AppController.class);

	public AppController() {
		super();
		System.out.println("app controller created");
	}

	@RequestMapping("/")
	String applicationEntry(HttpSession session) {
		
		log.fatal("fatal is called");
		log.error("error is called");
		log.warn("warn is called");
		log.info("info is called");
		log.debug("debug is called");
		log.trace("trace is called");
		
		
		UserDto userFromSesison = 
				(UserDto) session.getAttribute("userDetails");
		
		System.out.println("user from session " +
		userFromSesison);
		
		if (userFromSesison != null && 
				userFromSesison.getRole()
						.equals(AppConstants.ROLE_ADMIN)) {
			return "admindashboard";
		} else if (userFromSesison != null && 
				userFromSesison.getRole().
						equals(AppConstants.ROLE_USER)) {
			return "userdashboard";
		}

		System.out.println("entry point in application");
		return "start";
	}

}
