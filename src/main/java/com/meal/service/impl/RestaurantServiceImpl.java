package com.meal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meal.models.Dish;
import com.meal.models.Restaurant;
import com.meal.respository.RestaurantRepository;
import com.meal.services.RestaurantService;
@Service
public class RestaurantServiceImpl implements RestaurantService{

	private RestaurantRepository restaurantRepository;
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
		this.restaurantRepository = restaurantRepository;
		
	}
	@Override
	public List<Restaurant> getRestaurants() {
		// TODO Auto-generated method stub
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	@Override
	public Restaurant getRestaurant(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
		
	}

	@Override
	public void deleteRestaurant(String id) {
		// TODO Auto-generated method stub
		
	}

}
