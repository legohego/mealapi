package com.meal.services;

import java.util.List;

import com.meal.models.Dish;
import com.meal.models.User;

public interface UserService {

	List<User> getUsers();
	User getUser(String email, String password);
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(User user);
}
