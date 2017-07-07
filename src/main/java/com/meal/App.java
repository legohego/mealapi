package com.meal;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
  
	public static void main(String[] args) {
    SpringApplication.run(App.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		logger.info("this is run");
		logger.error("erioorororororororo");
		restaurantServiceImpl.createRestaurant(new Restaurant ("Quay Street"));
		restaurantServiceImpl.createRestaurant(new Restaurant ( "Tusnu"));
		restaurantServiceImpl.createRestaurant(new Restaurant ("Dail Bar"));
		restaurantServiceImpl.getRestaurants().forEach(Restaurant ->System.out.println(Restaurant.toString()));
		DishServiceImpl.createDish(new Dish ("Steak", "Lovely food"), "1");
		DishServiceImpl.createDish(new Dish ("Steak", "nice food"), "2");
		DishServiceImpl.createDish(new Dish ("Steak", "Best food"), "3");
		DishServiceImpl.createDish(new Dish ("Soup", "Worst food"), "1");
		DishServiceImpl.createDish(new Dish ("Soup", "Taste food"), "2");
	    DishServiceImpl.createDish(new Dish ("Soup", "Average food"), "3");
		DishServiceImpl.getDishes().forEach(Dish ->System.out.println(Dish.toString()));
		
	}

}
