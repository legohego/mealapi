package com.meal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.meal.exceptionhandler.NotFoundException;
import com.meal.models.Dish;
import com.meal.models.Restaurant;
import com.meal.respository.DishRepository;
import com.meal.respository.RestaurantRepository;
import com.meal.services.DishService;

@Service
public class DishServiceImpl implements DishService {
	private final Logger logger = LoggerFactory.getLogger("DishService");
	private DishRepository dishRepository;
	private RestaurantRepository restaurantRepository;

	@Autowired
	public DishServiceImpl(DishRepository dishRepository, RestaurantRepository restaurantRepository) {
		this.dishRepository = dishRepository;
		this.restaurantRepository = restaurantRepository;
	}

	public List<Dish> getDishes() throws NotFoundException {
	 List<Dish> dishList = (List<Dish>) dishRepository.findAll();
	 
		if (dishList == null) {
			throw new NotFoundException("No Dishes found for dishRepository.findAll()", "Method: getDishes");
		}
		return dishList;
	}

	public Dish getDish(String id) throws NotFoundException {

		Dish dish = dishRepository.findOne(id);
		if (dish == null) {
			throw new NotFoundException("No Dish found with id: " + id, "Method: getDishes");
		}
		return dish;
	}
	
	public List<Dish> getDishesByLocationAndName(String location, String name) {
		
		return null;
	}

	public Dish getFilteredDishes(String filter, String location, String dish) {
		return null;
	}

	public Dish createDish(Dish dish, String id) throws NotFoundException {
		Restaurant restaurant = restaurantRepository.findOne(id);
		if (restaurant == null) {
			throw new NotFoundException("No Restaurant found with id: " + id + ", Dish: " + dish.toString(),
					"Method: createDish");
		}
		dish.setRestaurant(restaurant);
		return dishRepository.save(dish);
	}

	// @Override
	public void updateDish(Dish dish) {
		// TODO Auto-generated method stub

	}

	// @Override
	public void deleteDish(Dish dish) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Dish> getDish(String location, String name, String[] filter) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteDish(String id) {
		try {
			dishRepository.delete(id);

		} catch (EmptyResultDataAccessException e) {

			logger.warn("Exceptioned caught on DishServiceImpl.deleteDish: " + e);
			id = null;
		}
		return id;
	}

}
