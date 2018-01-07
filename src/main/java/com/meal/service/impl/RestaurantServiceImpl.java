package com.meal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meal.exceptionhandler.NotFoundException;
import com.meal.models.Business;
import com.meal.models.Restaurant;
import com.meal.respository.BusinessRepository;
import com.meal.respository.RestaurantRepository;
import com.meal.services.RestaurantService;
@Service
public class RestaurantServiceImpl implements RestaurantService{

	private RestaurantRepository restaurantRepository;
	private BusinessRepository businessRepository;
	@Autowired
	public RestaurantServiceImpl(RestaurantRepository restaurantRepository, BusinessRepository businessRepository){
		this.restaurantRepository = restaurantRepository;
		this.businessRepository = businessRepository;
		
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
	
	public Restaurant createRestaurant(Restaurant restaurant, String id) throws NotFoundException {
		Business business = businessRepository.findOne(id);
		if (business == null) {
			throw new NotFoundException("No business found with id: " + id + ", Dish: " + business.toString(),
					"Method: createRestaurant");
		}
		restaurant.setBusiness(business);
		return restaurantRepository.save(restaurant);
	}

}
