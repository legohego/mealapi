package com.meal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meal.models.Dish;
import com.meal.models.User;
import com.meal.respository.DishRepository;
import com.meal.respository.UserRepository;
import com.meal.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	@Override
	public List<User> getUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUser(String email, String password) {
		
		return userRepository.findOne(email);
	}

	@Override
	public void createUser(User user) {
		
		
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
