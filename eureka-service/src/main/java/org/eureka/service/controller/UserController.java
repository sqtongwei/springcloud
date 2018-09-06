package org.eureka.service.controller;

import java.util.Date;

import org.eureka.service.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(value="/getUser")
	public User getUser() {
		
		User user = new User();
		user.setName("仝威");
		user.setAge(18);
		user.setBirth(new Date());
		return user;
	}

}
