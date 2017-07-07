package com.meal.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meal.models.Dish;
import com.meal.models.Restaurant;
import com.meal.services.DishService;
import com.meal.services.RestaurantService;

public class RestaurantController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	public RestaurantService restaurantService;

	@RequestMapping("/restaurants")
	@ResponseBody
	public ResponseEntity<Object> getRestaurants() {
		logger.info("GET: /restaurants/");
		List<Restaurant> restaurantList = restaurantService.getRestaurants();
		return new ResponseEntity<Object>(restaurantList, null != restaurantList? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/restaurant/")
	public ResponseEntity<Object> getRestaurant(@RequestParam(value = "id", required = true) String id) {
		logger.info("GET: /restaurant/?id=" + id);
		Restaurant restaurant =  restaurantService.getRestaurant(id);
		return new ResponseEntity <Object>(restaurant, null != restaurant? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/restaurant/")
	public ResponseEntity <Object>  setRestaurant(@RequestBody Restaurant restaurant) {
		logger.info("POST: /restaurant/, RequestBody: " + restaurant.toString());
		restaurant = restaurantService.createRestaurant(restaurant);
		return new ResponseEntity<Object>(restaurant, null != restaurant? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

}