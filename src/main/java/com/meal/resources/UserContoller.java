package com.meal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.meal.models.User;
import com.meal.service.impl.UserServiceImpl;

public class UserContoller {
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping(method=RequestMethod.GET, value ="/user")
	public User getUser(@RequestParam(value="email", required=true) String email, @RequestParam(value="password", required=true) String password){
		User user = getUser(email, password);
		return user;
	}
	@RequestMapping(method=RequestMethod.POST, value="/user")
	public void createUser(){
		
	}
	

}
