package com.meal.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meal.exceptionhandler.NotFoundException;
import com.meal.models.Dish;
import com.meal.respository.DishRepository;

public interface DishService {
	List<Dish> getDishes();
	Dish getDish(String id);
	Dish getFilteredDishes(String filter, String location, String dish);
	Dish createDish(Dish dish, String id) throws NotFoundException;
	void updateDish(Dish dish);
	void deleteDish(Dish dish);
}
