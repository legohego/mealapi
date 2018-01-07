package com.meal.services;
import java.util.List;
import com.meal.exceptionhandler.NotFoundException;
import com.meal.models.Dish;

public interface DishService {
	List<Dish> getDishes() throws NotFoundException;
	Dish getDish(String id) throws NotFoundException;
	Dish getFilteredDishes(String filter, String location, String dish);
	Dish createDish(Dish dish, String id) throws NotFoundException;
	void updateDish(Dish dish);
	void deleteDish(Dish dish);
}
