package com.meal;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.meal.models.Business;
import com.meal.models.Dish;
import com.meal.models.Restaurant;
import com.meal.service.impl.DishServiceImpl;
import com.meal.service.impl.RestaurantServiceImpl;

@SpringBootApplication
public class App implements CommandLineRunner{
	 Logger logger = Logger.getLogger(App.class.getName());
    @Autowired
    private DishServiceImpl DishServiceImpl;
    @Autowired
    private RestaurantServiceImpl restaurantServiceImpl;
   // @Autowired
   // private BusinessServiceImpl businessServiceImpl;
  
	public static void main(String[] args) {
    SpringApplication.run(App.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
        Business business = new Business("viacom");
		restaurantServiceImpl.createRestaurant(new Restaurant ("Quay Street"), "1");
		restaurantServiceImpl.createRestaurant(new Restaurant ( "Tusnu"), "1");
		restaurantServiceImpl.createRestaurant(new Restaurant ("Dail Bar"), "1");
		DishServiceImpl.createDish(new Dish ("Steak", "Lovely food"), "1");
		DishServiceImpl.createDish(new Dish ("Steak", "nice food"), "2");
		DishServiceImpl.createDish(new Dish ("Steak", "Best food"), "3");
		DishServiceImpl.createDish(new Dish ("Soup", "Worst food"), "1");
		DishServiceImpl.createDish(new Dish ("Soup", "Taste food"), "2");
	    DishServiceImpl.createDish(new Dish ("Soup", "Average food"), "3");
		DishServiceImpl.getDishes().forEach(Dish ->System.out.println(Dish.toString()));
		
	}

}
