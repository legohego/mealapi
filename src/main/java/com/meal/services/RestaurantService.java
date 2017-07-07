package com.meal.services;

import java.util.List;

import com.meal.models.Restaurant;

public interface RestaurantService {

	List<Restaurant> getRestaurants();

	Restaurant getRestaurant(String id);

	Restaurant createRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(String id);

}
