package org.eureka.service.controller;

import java.util.Date;

import org.eureka.service.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Value("${server.port}")
	String port;
	
	@Value("${name}")
	String name;
	@GetMapping(value="/name")
	public String hi() {
		return "你好," + name;
	}
	
	@GetMapping(value="/getUser")
	public User getUser(@RequestParam(value = "name") String name) {
		
		User user = new User();
		user.setName(name);
		user.setAge(18);
		user.setBirth(new Date());
		
		System.out.println("eureka-service port:" + port);
		return user;
	}

}
